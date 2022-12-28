package com.attson.knife4jserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.attson.knife4jserver.config.ServerConfig;
import com.attson.knife4jserver.response.Response;
import com.attson.knife4jserver.service.LoginUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class V3Controller {

    @Autowired
    ServerConfig serverConfig;

    @GetMapping("/v3/api-docs/{doc}")
    public ResponseEntity<String> docs(@PathVariable String doc) {
        try {
            try (FileInputStream fileInputStream = new FileInputStream("/var/knife4j-server/files/" + doc + ".json");) {
                byte[] bytes = fileInputStream.readAllBytes();
                return ResponseEntity.ok(new String(bytes, Charset.defaultCharset()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private HashMap<String, Object> loginSupport() {
        HashMap<String, Object> login = new HashMap<>();

        if (serverConfig.getLogin() != null) {
            if (serverConfig.getLogin().getFeishu() != null) {
                login.put(
                        "feishu", Map.of(
                                "appId", serverConfig.getLogin().getFeishu().getAppId(),
                                "path", "/login/feishu"
                        )
                );
            }

            return login;
        } else {
            return null;
        }
    }

    @GetMapping("/v3/api-docs/swagger-config")
    public ResponseEntity<HashMap<String, Object>> swaggerConfig() throws IOException {
        HashMap<String, Object> res = new HashMap<>();
        res.put("configUrl", "/v3/api-docs/swagger-config");
        res.put("oauth2RedirectUrl", "http://127.0.1.1:8999/swagger-ui/oauth2-redirect.html");
        res.put("operationsSorter", "alpha");
        res.put("tagsSorter", "alpha");

        HashMap<String, Object> loginSupport = this.loginSupport();
        if (loginSupport != null) {
            res.put("loginSupport", loginSupport);
            res.put("loginAuthHeader", LoginUserService.AUTH_ID_HEADER);
        }

        var urls = new ArrayList<HashMap>();

        try (Stream<Path> paths = Files.walk(Path.of("/var/knife4j-server/files/"))) {
            paths.filter(path -> path.toString().endsWith("json"))
                    .forEach(path -> {
                        try {
                            FileInputStream fileInputStream = new FileInputStream(path.toString());
                            byte[] bytes = fileInputStream.readAllBytes();

                            JSONObject parse = (JSONObject) JSON.parse(new String(bytes, Charset.defaultCharset()));
                            HashMap<Object, Object> url = new HashMap<>();

                            String[] split = path.getFileName().toString().split("\\.");
                            url.put("url", "/v3/api-docs/" + split[0]);

                            String name = parse.getJSONObject("info").getString("title");
                            if (Strings.isBlank(name)) {
                                name = split[0];
                            }
                            url.put("name", name);

                            urls.add(url);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        }

        res.put("urls", urls);
        res.put("validatorUrl", "");

        return ResponseEntity.ok(res);
    }

    @PostMapping("/upload")
    public Response<String> upload(@RequestParam("file") MultipartFile file,
                                   @RequestParam("serviceName") @NonNull String serviceName
    ) {
        if (file.isEmpty()) {
            throw new RuntimeException("file not found.");
        }

        String filePath = "/var/knife4j-server/files/";

        File dest = new File(filePath + serviceName + ".json");
        try {
            file.transferTo(dest);

            return Response.ok("success");
        } catch (IOException e) {
            return Response.fail(e.getMessage());
        }
    }
}

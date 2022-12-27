# Description

```json5
{
  "configUrl": "/v3/api-docs/swagger-config",
  "oauth2RedirectUrl": "http://127.0.1.1:8999/swagger-ui/oauth2-redirect.html",
  "operationsSorter": "alpha",
  "tagsSorter": "alpha",
  "urls": [
    {
      "url": "/v3/api-docs/default",
      "name": "default"
    }
  ],
  "validatorUrl": ""
}
```

```json5
{
  "openapi": "3.0.1",
  "info": {
    "title": "XXX用户系统API",
    "description": "Knife4j集成springdoc-openapi示例",
    "termsOfService": "http://doc.xiaominfo.com",
    "license": {
      "name": "Apache 2.0",
      "url": "http://doc.xiaominfo.com"
    },
    "version": "1.0"
  },
  "servers": [
    {
      "url": "http://127.0.1.1:8999",
      "description": "Generated server url"
    }
  ],
  "paths": {
    "/body/bodyPut": {
      "put": {
        "tags": [
          "body参数"
        ],
        "summary": "普通body请求-put",
        "operationId": "bodyPut",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/user/{deviceId}/body": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "body请求",
        "operationId": "bodyRequest",
        "parameters": [
          {
            "name": "deviceId",
            "in": "path",
            "description": "设备id",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "type": "object"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/UserSchema"
                }
              }
            }
          }
        }
      }
    },
    "/user/{deviceId}/body1": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "body请求1",
        "operationId": "bodyRequest1",
        "parameters": [
          {
            "name": "deviceId",
            "in": "path",
            "description": "设备id",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/UserSchema"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/UserSchema"
                }
              }
            }
          }
        }
      }
    },
    "/user/getRequest1": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "json参数查询1",
        "operationId": "getRequest1",
        "parameters": [
          {
            "name": "cade",
            "in": "query",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/UserSchema"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/UserSchema"
                }
              }
            }
          }
        }
      }
    },
    "/user/createOne": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "创建用户-createOne",
        "description": "根据姓名创建用户1",
        "operationId": "createOne",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/User"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/User"
                }
              }
            }
          }
        }
      }
    },
    "/user/createOneSchema": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "创建用户-Schema",
        "description": "根据姓名创建用户1",
        "operationId": "createOneSchema",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/UserSchema"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/UserSchema"
                }
              }
            }
          }
        }
      }
    },
    "/user/createOne1": {
      "post": {
        "tags": [
          "用户模块"
        ],
        "summary": "创建用户1",
        "description": "根据姓名创建用户1",
        "operationId": "createOne1",
        "parameters": [
          {
            "name": "id",
            "in": "query",
            "description": "主键id",
            "required": false,
            "schema": {
              "type": "string",
              "description": "主键id",
              "default": "1"
            }
          },
          {
            "name": "name",
            "in": "query",
            "description": "名称",
            "required": false,
            "schema": {
              "type": "string",
              "description": "名称",
              "default": "张飞"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/User"
                }
              }
            }
          }
        }
      }
    },
    "/file/upload": {
      "post": {
        "tags": [
          "文件上传"
        ],
        "summary": "单纯文件上传",
        "description": "单纯文件上传，无任何参数",
        "operationId": "upload",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "required": [
                  "file"
                ],
                "type": "object",
                "properties": {
                  "file": {
                    "type": "string",
                    "format": "binary"
                  }
                }
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/file/uploadParam": {
      "post": {
        "tags": [
          "文件上传"
        ],
        "summary": "文件上传-带参数",
        "operationId": "uploadParam",
        "parameters": [
          {
            "name": "name",
            "in": "query",
            "description": "文件名称",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "file",
            "description": "文件",
            "required": true,
            "$ref": "#/components/parameters/file"
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "required": [
                  "file"
                ],
                "type": "object",
                "properties": {
                  "file": {
                    "type": "string",
                    "format": "binary"
                  }
                }
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/file/uploadParamHeader": {
      "post": {
        "tags": [
          "文件上传"
        ],
        "summary": "文件上传-带参数Header",
        "operationId": "uploadParamHeader",
        "parameters": [
          {
            "name": "token",
            "in": "header",
            "description": "请求token",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "query",
            "description": "文件名称",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "file",
            "description": "文件",
            "required": true,
            "$ref": "#/components/parameters/file"
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "required": [
                  "file"
                ],
                "type": "object",
                "properties": {
                  "file": {
                    "type": "string",
                    "format": "binary"
                  }
                }
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/file/uploadParam/{id}": {
      "post": {
        "tags": [
          "文件上传"
        ],
        "summary": "文件上传-带参数Path",
        "operationId": "uploadParamPath",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "文件id",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "query",
            "description": "文件名称",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "file",
            "description": "文件",
            "required": true,
            "$ref": "#/components/parameters/file"
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "required": [
                  "file"
                ],
                "type": "object",
                "properties": {
                  "file": {
                    "type": "string",
                    "format": "binary"
                  }
                }
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/file/uploadBatch": {
      "post": {
        "tags": [
          "文件上传"
        ],
        "summary": "多文件上传",
        "operationId": "uploadBatch",
        "parameters": [
          {
            "name": "file",
            "description": "文件",
            "$ref": "#/components/parameters/file"
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "required": [
                  "files"
                ],
                "type": "object",
                "properties": {
                  "files": {
                    "type": "array",
                    "items": {
                      "type": "string",
                      "format": "binary"
                    }
                  }
                }
              }
            }
          }
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "array",
                  "items": {
                    "$ref": "#/components/schemas/文件name"
                  }
                }
              }
            }
          }
        }
      }
    },
    "/body1/mo": {
      "post": {
        "tags": [
          "aaa参数"
        ],
        "summary": "枚举可用值",
        "operationId": "mo",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/MapEnumUser"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/MapEnumUser"
                }
              }
            }
          }
        }
      }
    },
    "/body1/mo1": {
      "post": {
        "tags": [
          "aaa参数"
        ],
        "summary": "枚举可用值1",
        "operationId": "mo1",
        "parameters": [
          {
            "name": "mapEnumUser",
            "in": "query",
            "required": true,
            "schema": {
              "$ref": "#/components/schemas/MapEnumUser"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/MapEnumUser"
                }
              }
            }
          }
        }
      }
    },
    "/body1/ee/body1": {
      "post": {
        "tags": [
          "aaa参数"
        ],
        "summary": "普通body请求3",
        "operationId": "body",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body1/dd/body1": {
      "post": {
        "tags": [
          "aaa参数"
        ],
        "summary": "普通body请求2",
        "operationId": "body23",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body1/cc/body1": {
      "post": {
        "tags": [
          "aaa参数"
        ],
        "summary": "普通body请求1",
        "operationId": "body2",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body/body": {
      "post": {
        "tags": [
          "body参数"
        ],
        "summary": "普通body请求",
        "operationId": "body_1",
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body/bodyParam": {
      "post": {
        "tags": [
          "body参数"
        ],
        "summary": "普通body请求+Param",
        "operationId": "bodyParam",
        "parameters": [
          {
            "name": "name",
            "in": "query",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body/bodyParamHeader": {
      "post": {
        "tags": [
          "body参数"
        ],
        "summary": "普通body请求+Param+Header",
        "operationId": "bodyParamHeader",
        "parameters": [
          {
            "name": "token",
            "in": "header",
            "description": "请求token",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "query",
            "description": "文件名称",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/body/bodyParamHeaderPath/{id}": {
      "post": {
        "tags": [
          "body参数"
        ],
        "summary": "普通body请求+Param+Header+Path",
        "operationId": "bodyParamHeaderPath",
        "parameters": [
          {
            "name": "id",
            "in": "path",
            "description": "文件id",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "token",
            "in": "header",
            "description": "请求token",
            "required": true,
            "schema": {
              "type": "string"
            }
          },
          {
            "name": "name",
            "in": "query",
            "description": "文件名称",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/文件name"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "$ref": "#/components/schemas/文件name"
                }
              }
            }
          }
        }
      }
    },
    "/user1/create": {
      "get": {
        "tags": [
          "用户模块1"
        ],
        "summary": "创建用户",
        "description": "根据姓名创建用户",
        "operationId": "create",
        "parameters": [
          {
            "name": "name",
            "in": "query",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "202": {
            "description": "OK",
            "content": {
              "*/*": {
                "example": {
                  "message": "finished",
                  "id": "101"
                }
              }
            }
          }
        }
      }
    },
    "/user/getRequest": {
      "get": {
        "tags": [
          "用户模块"
        ],
        "summary": "json参数查询",
        "operationId": "getRequest",
        "parameters": [
          {
            "name": "userSchema",
            "in": "query",
            "required": true,
            "schema": {
              "$ref": "#/components/schemas/UserSchema"
            }
          },
          {
            "name": "cade",
            "in": "query",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/UserSchema"
                }
              }
            }
          }
        }
      }
    },
    "/user/create": {
      "get": {
        "tags": [
          "用户模块"
        ],
        "summary": "创建用户",
        "description": "根据姓名创建用户",
        "operationId": "create_1",
        "parameters": [
          {
            "name": "name",
            "in": "query",
            "required": true,
            "schema": {
              "type": "string"
            }
          }
        ],
        "responses": {
          "200": {
            "description": "OK",
            "content": {
              "*/*": {
                "schema": {
                  "type": "string"
                }
              }
            }
          }
        }
      }
    },
    "/job3/download": {
      "get": {
        "tags": [
          "文件下载1"
        ],
        "operationId": "download",
        "responses": {
          "200": {
            "description": "OK"
          }
        }
      }
    },
    "/download/xlsx": {
      "get": {
        "tags": [
          "文件下载"
        ],
        "summary": "下载excel文件",
        "operationId": "pdf",
        "responses": {
          "200": {
            "description": "OK"
          }
        }
      }
    },
    "/download/text": {
      "get": {
        "tags": [
          "文件下载"
        ],
        "summary": "下载txt文件",
        "operationId": "text",
        "responses": {
          "200": {
            "description": "OK"
          }
        }
      }
    },
    "/download/image": {
      "get": {
        "tags": [
          "文件下载"
        ],
        "summary": "图片预览",
        "operationId": "image",
        "responses": {
          "200": {
            "description": "OK"
          }
        }
      }
    },
    "x-abb": 93
  },
  "components": {
    "schemas": {
      "文件name": {
        "type": "object",
        "properties": {
          "random": {
            "type": "string",
            "description": "随机名称"
          },
          "name": {
            "type": "string",
            "description": "文件名称"
          },
          "size": {
            "type": "integer",
            "description": "文件大小",
            "format": "int64"
          },
          "success": {
            "type": "boolean",
            "description": "是否上传成功"
          }
        },
        "description": "文件对象"
      },
      "UserSchema": {
        "type": "object",
        "properties": {
          "id": {
            "title": "注解id-title",
            "type": "string",
            "description": "主键id",
            "default": "1"
          },
          "name": {
            "type": "string",
            "description": "名称",
            "default": "张飞"
          },
          "partSchema": {
            "$ref": "#/components/schemas/文件part对象"
          }
        },
        "description": "用户信息"
      },
      "文件part对象": {
        "type": "object",
        "properties": {
          "id": {
            "type": "string",
            "description": "part部分id",
            "default": "1"
          },
          "name": {
            "type": "string",
            "description": "part部分名称",
            "default": "张飞"
          }
        },
        "description": "Part信息"
      },
      "User": {
        "type": "object",
        "properties": {
          "id": {
            "type": "string",
            "description": "主键id",
            "default": "1"
          },
          "name": {
            "type": "string",
            "description": "名称",
            "default": "张飞"
          }
        }
      },
      "MapEnumUser": {
        "type": "object",
        "properties": {
          "name": {
            "type": "string",
            "description": "姓名",
            "enum": [
              "张飞,关羽,赵云"
            ]
          },
          "courseType": {
            "type": "string",
            "description": "枚举类型",
            "enum": [
              "102:图文",
              "103:音频",
              "104:视频",
              "105:外链"
            ]
          }
        }
      }
    }
  },
  "x-test123": "333",
  "x-openapi": {
    "x-setting": {
      "customCode": 200,
      "language": "zh-CN",
      "enableSwaggerModels": true,
      "swaggerModelName": "实体类列表",
      "enableReloadCacheParameter": false,
      "enableAfterScript": true,
      "enableDocumentManage": true,
      "enableVersion": false,
      "enableRequestCache": true,
      "enableFilterMultipartApis": false,
      "enableFilterMultipartApiMethodType": "POST",
      "enableHost": false,
      "enableHostText": "",
      "enableDynamicParameter": false,
      "enableDebug": true,
      "enableFooter": true,
      "enableFooterCustom": false,
      "enableSearch": true,
      "enableOpenApi": true,
      "enableHomeCustom": false,
      "enableGroup": true,
      "enableResponseCode": true
    },
    "x-markdownFiles": [
      {
        "group": "default",
        "name": "标题1",
        "children": [
          {
            "title": "测试以下文档",
            "content": "# 测试以下文档\n\n\n我是内容"
          },
          {
            "title": "测试以下文档1",
            "content": "# 测试以下文档1\n\n\n我是内容1"
          }
        ]
      },
      {
        "group": "用户模块",
        "name": "标题2",
        "children": [
          {
            "title": "测试以下文档1111",
            "content": "# 测试以下文档1111\n\n\n我是内容1111"
          },
          {
            "title": "测试以下文档1222",
            "content": "# 测试以下文档1222\n\n\n我是内容1222"
          }
        ]
      }
    ]
  }
}
```
# 数据库

## 商品表

### 表结构

```
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `price` varchar(255) NOT NULL,
  `introduction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
```



## 订单表

### 表结构

```
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `ordername` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `orderdate` timestamp NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
```



## 用户表

### 表结构

```
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
```



# 接口文档

 部分接口举例

## 用户相关

### 用户注册

- 接口简介：用户注册
- Type：POST
- URL：

```
/user/signup
```



- 请求参数：

| 字段     | 说明   |
| -------- | ------ |
| username | 用户名 |
| password | 密码   |

- 请求参数样例：

```
{
    "username":"test",
    "password":"123456"
}
```

> 注意：
>
> 1. json格式传递，content-type:application/json
> 2. table_name测试的时候修改一下，重名会提示错误信息

- 返回结果参数说明：

| 字段 | 说明     |
| ---- | -------- |
| msg  | 状态信息 |
| code | 状态码   |

- 返回参数样例：

```
{
    "msg": "ok",
    "code": "200"
}
```

## 商品相关

### 查看商品列表

- 接口简介：查询所有商品的详情信息
- Type：GET
- URL：

```
/goods/list
```

- 请求参数：

​       无



- 返回结果参数说明：

| 字段         | 说明     |
| ------------ | -------- |
| name         | 商品名称 |
| price        | 价格     |
| introduction | 商品介绍 |

- 返回参数样例：

```
[
    {
        "name": "folks",
        "price": "20",
        "introduction": "很好用"
    },
    {
        "name": "plates",
        "price": "20",
        "introduction": "好用"
    }
]
```

### 查看商品详情

- 接口简介：通过商品名字查找商品详情
- Type：GET
- URL：

```
/goods/find
```



- 请求参数：

| 字段 | 说明     |
| ---- | -------- |
| name | 商品名称 |



- 返回结果参数说明：

| 字段         | 说明     |
| ------------ | -------- |
| name         | 商品名称 |
| price        | 价格     |
| introduction | 商品介绍 |

- 返回参数样例：

```
[
    {
        "name": "folks",
        "price": "20",
        "introduction": "很好用"
    }
]
```
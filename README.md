## 页面展示：

![](https://github.com/zmdlbr/MyPictures/blob/04fab94ae8137c7017aa2da112635049c454a9ed/SSM-DEMO/SSM-DEMO.png?raw=true)

## 功能简介：

* Shiro验证---后台登录
* 安全退出后台,修改用户密码---MD5保存密码
* 修改用户信息----上传图片---个人头像
* 文章管理--文章CRUD---分别使用UE和KE编辑器
* 图片管理--图片CRUD--JQuery图片上传插件Uploadify

## 框架实现：

EasyUI+Spring+SpringMVC+MyBatis

**图片管理**

使用了JQuery图片上传插件Uploadify！！！

JQuery的文件上传控件，支持ajax无刷新上传，多个文件同时上传，上传进行进度显示，删除已上传文件。

1.先下载Uploadify的压缩包，然后解压，把里面的文件解压到你的项目的文件夹中。其中有用的文件就是四个。

jquery.uploadify.js（jquery.uploadify.min.js），uploadify.css，uploadify.swf，uploadify-cancel.png

2.因为这种无刷新上传全是通过flash实现的，所以我们还要去下载一个swfobject.js，swfobject.js的下载地址：https://github.com/swfobject/swfobject

3.还需要jquery.min.js

具体使用：参考文档：http://www.uploadify.com/documentation/

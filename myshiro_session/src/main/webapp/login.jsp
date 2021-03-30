<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="" method="post">
    用户名：<input type="text" name="username"><br/>
    密码：<input type="password" name="password"><br/>
    性别：<input type="radio" name="gender">男<input type="radio" name="gender">女<<br/>
    爱好：<input type="checkbox" name="gender">看书<input type="checkbox" name="gender">打球<<br/>
    <input type="submit" value="提交">
</form>

</body>
</html>
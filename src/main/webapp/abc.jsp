<%--
  Created by IntelliJ IDEA.
  User: lhz
  Date: 2019/1/14
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>参数</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.0.js">
</script>
<script type="text/javascript">
    $(document).ready(function () {
        //模拟30000个异步请求,进行并发
        var max=30000;
        for (var i = 1;i<=max;i++){
            //jquery的异步请求!
            $.post({
                url:".userRedPacket/grapRedPacket.do?redPacketId=1&userId="+i,
                //成功后的方法
                success:function (result) {

                }
            });
        }
    })
</script>


<body>

</body>
</html>

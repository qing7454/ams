<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<title>欢迎登录</title>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/theme/entrance.teal.css"/>
	<link href="${path}/resources/css/ui.css" rel="stylesheet" type="text/css" />
	<link href="${path}/resources/css/base.css" rel="stylesheet" type="text/css" />
	<script src="${path}/resources/js/jquery-1.7.2.min.js" type="text/javascript"></script>
	<script src="${path}/resources/js/config.js" type="text/javascript"></script>
	<script src="${path}/resources/js/jquery.cookie.js" type="text/javascript"></script>
	<script type="text/javascript">

		//误删，避免frameset中的登陆界面session过期在子框架加载的问题
		if (top.location != self.location){  
			top.location=self.location;  
		}
	    
	    function check(){
	    	var username = $("#txtUsername").val();
            var password = $("#txtPassword").val();
            var authCode = $("#authCode").val();
            if (username == "")            {
                Public.tips({type: 1, content : '账号不能为空!'});
                $("#txtUsername").focus();
                return false;
            }
            if (password == "")            {
                Public.tips({type: 1, content : '密码不能为空!'});
                $("#txtPassword").focus();
                return false;
            }
           /*  if(authCode==""){
            	Public.tips({type: 1, content : '验证码不能为空!'});
                $("#authCode").focus();
                return false;
            } */
            return true;
	    }
	    
	    function showImage(node){
			var imageHtml = '<img src="${path}/authImg?rand=' + Math.random() + '" onclick="showImage(this);" width="100" height="26"/>';
			$(node).replaceWith(imageHtml);
		}
	</script>
</head>
<body>
        <div class="loginbox">
            <div class="loginlogo"></div>
            <div class="loginpanel">
                <div class="panel-h"></div>
                <div class="panel-c">
                    <div class="panel-c-l">
                        <form action="${path }/signIn" id="form1" method="post">                 
                            <table>
                                <tbody>
                                    <tr>
                                        <td colspan="2" style="text-align: left;"> 
                                            <h3>
                                                <em class="title">&nbsp;登 录</em>
                                                <em class="icn-border direct-r r-ext"></em>
                                            </h3>
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td class="right">账&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
                                        <td style="text-align: left;">
                                            <input type="text" name="name" id="wscrm_Username" class="login-text" value="admin" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="right">密&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
                                        <td class="left">
                                            <input type="password" name="pass" id="wscrm_Password" class="login-text" value="admin" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="right">验证码：</td>
                                        <td class="left">
                                            <input type="text" name="authCode" id="authCode" class="login-text" style="width:90px;" value="屏蔽验证码"/>
	                                        <img alt="" src="${path}/authImg" onclick="showImage(this)" width="100" height="25" style="vertical-align: middle;">
                                        </td>
                                    </tr> 
                                    <tr>
                                        <td colspan="2">
                                            <div class="ht_10"></div>
                                            <input type="submit" value="登&nbsp;&nbsp;录&nbsp;&nbsp;" class="login-btn" onClick="return check();"/>
                                        </td>
                                    </tr> 
                                </tbody>
                            </table>
                        </form>  
                    </div>
                    <div class="panel-c-r">
                        <h1 class="t-orgname">管理系统&nbsp;&raquo;</h1>
                        <div class="ht_10"></div>
                        <div>
                            <ul class="ul-tips">
                                <li>请正确输入账号和密码进行登录。</li>
                                <li>如遇到登录问题，请联系网络管理员。</li>
                            </ul>	 
                        </div>               
                        <!-- <p>...</p> -->
                    </div>
                </div>
                <div class="panel-f"></div>
            </div>
            <div class="logincopyright">
                <p>
                    <span style="font-family: 'Microsoft Yahei', arial, Sans-Serif;">&copy;</span> 2016 CTGU CompanyName Co.,Ltd.
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    Powered  by XXX.
                </p>
            </div>
        </div>
    </body>
    <script type="text/javascript">
    	<c:if test="${not empty error}">
    		Public.tips({type: 1, content : '${error}'});
    	</c:if>
    </script>
</html>
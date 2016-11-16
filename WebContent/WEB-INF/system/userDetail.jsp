<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html >
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<title>用户详细</title>
	<link href="${path}/resources/ligerUI/skins/Gray/css/ligerui-all.css" rel="stylesheet" type="text/css"> 
	<link href="${path}/resources/css/main2.css" rel="stylesheet" type="text/css" />
    <link href="${path}/resources/css/ui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/resources/css/base.css" rel="stylesheet" type="text/css" />
    
    <script src="${path}/resources/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${path}/resources/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#btnEdit").bind("click",function(){
				var tabId=parent.tab.getSelectedTabItemID();
				parent.Public.addTab("jsbj${user.userId}","用户编辑","${path}/userRole/edit?id=${user.userId}");
				parent.Public.pageTabClose(tabId);
			});
			$("#btnClose").bind("click",function(){
				parent.tab.removeSelectedTabItem();					
			});
		});
	</script>
</head>
<body>
	
	<div id="man_zone" class="clear">
        <table class="op_tb">
            <caption style="text-align: center;">基础信息</caption>
            <tbody>
                <tr>
                    <td class="label">
                    	用&nbsp;户&nbsp;名
                    </td>
                    <td>
                        ${user.userName }                  
                    </td>
                </tr>
                <tr>
                    <td class="label">
                       	角&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;色
                    </td>
                    <td>
                    	<c:forEach items="${roleList }" var="item" varStatus="sta">
                        	<span>${item.roleName }</span>
                        	<c:if test="${not sta.last }">&nbsp;|&nbsp;</c:if>
                        </c:forEach>
                    </td>
                </tr>   
                <tr>
                    <td class="label">
                       	姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名
                    </td>
                    <td>
                        ${user.realName }
                    </td>
                </tr>
                <tr>
                    <td class="label">
                       	电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话
                    </td>
                    <td>
                        ${user.phone }
                    </td>
                </tr>
                <tr>
                    <td class="label">
                       	部&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;门
                    </td>
                    <td>
                        ${user.departId }
                    </td>
                </tr> 
                 <tr>
					<td colspan="2" align="center">
						<input type="button" class="ui-btn ui-btn-sp" id="btnEdit" value="修改" />&nbsp;&nbsp;
					    <input type="button" class="ui-btn-rad button blue" id="btnClose" value="关闭" />
                    </td>
				</tr>
            </tbody>
        </table>
    </div>
</body>
</html>
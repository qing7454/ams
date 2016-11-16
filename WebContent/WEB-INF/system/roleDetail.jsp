<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<title>角色详细</title>
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
				parent.Public.addTab("jsbj${role.roleId}","角色编辑","${path}/role/edit?id=${role.roleId}");
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
            <caption style="text-align: center;">
            	角色详细 
            </caption>
            <tbody>
                <tr>
                    <td class="label">
                       	角色名称
                    </td>
                    <td>
                        ${role.roleName }                    
                    </td>
                </tr>                        
                <tr>
                    <td class="label">
                     	用户权限
                    </td>
                    <td>
						<c:forEach items="${authList }" var="item" varStatus="sta">
							${item.authName }
							<c:if test="${not sta.last }">&nbsp;|&nbsp;</c:if>
						</c:forEach>
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
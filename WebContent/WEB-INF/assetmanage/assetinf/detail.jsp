<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<title>资产信息详情</title>
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
				parent.Public.addTab("zcbj${model.assetId}","资产编辑","${path}/assetmanage/assetinf/edit?id=${model.assetId}");
				parent.Public.pageTabClose(tabId);
			});
			$("#btnClose").bind("click",function(){
				parent.tab.removeSelectedTabItem();					
			});
		});
	</script>
</head>
<body>
    <div class="man_zone">
         <table class="op_tb">
         	<caption style="text-align: center;">
         		资产信息表 
         	</caption>
             <tbody>
                 <tr>
                     <td class="label">
                          	资产编号：
                     </td>
                     <td>
                         ${model.assetId }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                         	资产名称：
                     </td>
                     <td>
                         ${model.assetnameId }
                     </td>
                 <%-- </tr>
                 <tr>
                     <td class="label">
                          	资产出厂编号：
                     </td>
                     <td>
                         ${model.assetserialCode }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                          	所属项目编号：
                     </td>
                     <td>
                         ${model.projectNumber }
                     </td>
                 </tr> --%>
                 <tr>
                     <td class="label">
                          	资产品牌：
                     </td>
                     <td>
                         ${model.assetBrand }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                          	资产型号：
                     </td>
                     <td>
                         ${model.assetinfoVersion }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                          	资产价格：
                     </td>
                     <td>
                         ${model.assetinfoPrice }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                          	图片：
                     </td>
                     <td>
                         ${model.assetinfoPic }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                          	资产状态：
                     </td>
                     <td>
                         ${model.assetStatus }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	 采购人：
                     </td>
                     <td>
                         ${model.agentPurchaser}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	 使用者：
                     </td>
                     <td>
                         ${model.userId}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	制造日期：
                     </td>
                     <td>
                         ${model.assetmadeTime}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	 购买日期：
                     </td>
                     <td>
                         ${model.assetinfoTime}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	 启用日期：
                     </td>
                     <td>
                         ${model.startUseTime}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	 厂商：
                     </td>
                     <td>
                         ${model.assetfactoryId}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	供应商：
                     </td>
                     <td>
                         ${model.supplierId}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	项目：
                     </td>
                     <td>
                         ${model.projectId}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	维护公司：
                     </td>
                     <td>
                         ${model.maintenanceId}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                        	安装地点：
                     </td>
                     <td>
                         ${model.instaLocation}
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                         	使用年限：
                     </td>
                     <td>
                         ${model.usedYears }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                         	生命年限：
                     </td>
                     <td>
                         ${model.lifeYears }
                     </td>
                 </tr>
                 <tr>
                     <td class="label">
                             	备注：
                     </td>
                     <td>
                        ${model.remark }
                     </td>
                 </tr>
                 <tr>
                     <td colspan="2" class="toolbottom" align="center">
                     	<input type="button" class="ui-btn ui-btn-sp" id="btnEdit" value="修改" />&nbsp;&nbsp;
			    		<input type="button" class="ui-btn-rad button blue" id="btnClose" value="关闭" />
                     </td>
                 </tr>
             </tbody>
         </table>   
     </div>
</body>
</html>
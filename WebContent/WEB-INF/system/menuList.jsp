<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>菜单列表</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<link href="${path}/resources/ligerUI/skins/Gray/css/ligerui-all.css" rel="stylesheet" type="text/css"> 
	<link href="${path}/resources/css/main2.css" rel="stylesheet" type="text/css" />
    <link href="${path}/resources/css/ui.css" rel="stylesheet" type="text/css" />
    <link href="${path}/resources/css/base.css" rel="stylesheet" type="text/css" />
    
    <script src="${path}/resources/js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="${path}/resources/ligerUI/js/ligerui.all.js" type="text/javascript"></script>
    <script src="${path}/resources/js/config.js" type="text/javascript"></script>
	
	<script type="text/javascript">
	    var menuTree=null;
		$(document).ready(function(){
			//初始化tree
			var data =[];
			var JSONdata=JSON.parse('${menuList}');
			menuTree=$("#menuTree").ligerTree({  
		        data:JSONdata, 
		        isExpand: 2,
		        nodeWidth: 300,
		        checkbox: false,
		        single:true,
				slide: true,
		        idFieldName :'menuId',
		        parentIDFieldName :'parentId',
		        textFieldName:'name'
		    });
		});
		var state;//记录是增加还是修改
		//重载
        function reload()
        {
            window.location.reload();
        }

        //添加
        function addTreeItem()
        {
        	state=1;
        	var node = menuTree.getSelected();
        	if(node){
	        	openMenu("菜单","${path}/menu/add?parentId="+node.data.menuId);
        	}else{
        		parent.Public.tips({type: 2, content : "请选择节点！"});
        	}
        }
        //修改
        function updateTreeItem()
        {
        	state=2;
        	var node = menuTree.getSelected();
        	if(node){
        		openMenu("菜单","${path}/menu/edit?id="+node.data.menuId);
        	}else{
        		parent.Public.tips({type: 2, content : "请选择节点！"});
        	}
        }
        //删除
        function removeTreeItem()
        {
        	var node = menuTree.getSelected();
            if (node){
	        	parent.Public.ajaxPost("${path}/menu/delete?id="+node.data.menuId,"",function(data){
	        		data=eval(data);
	        		if(data.state){
		                menuTree.remove(node.target);
		                parent.Public.tips({type: 0, content : data.message});
	        		}else{
	        			parent.Public.tips({type: 1, content : data.message});
	        		}
	        	});
            }
            else
            	parent.Public.tips({type: 2, content : "请选择节点！"});
        }
        
        /**
		 * 菜单编辑框
		 */
		function openMenu(title,url){
			$.ligerDialog.open({ title: title, name:'menuSelector',width: 800,height:400,isResize:true,timeParmName:'tmp', url: url, buttons: [
			     { text: '确定', onclick: menuOK },
			     { text: '取消', onclick: popCancel }
			 ]});
			 return false;
		}
		
        function menuOK(item, dialog)
        {
			var fn = dialog.frame.f_save || dialog.frame.window.f_save; 
            var data = fn(); 
            if (null!=data)
            {
            	data=eval(data);
	            if(data.state){
	            	parent.Public.tips({type: 0, content : data.message});
	            	if(state==1){//增加
	            		parent.Public.ajaxPost("${path}/menu/detail?id="+data.param,"",function(obj){
	            			var node = menuTree.getSelected();
	            			var nodes = [];
	                        nodes.push(obj);
	                        if (node)
	                        	menuTree.append(node.target, nodes); 
	            		});
	            	}else if(state==2){//更新
	            		parent.Public.ajaxPost("${path}/menu/detail?id="+data.param,"",function(obj){
	            			var node = menuTree.getSelected();
	                        if (node)
	                        	menuTree.update(node.target, obj);
	            		});
	            	}else{}
	            }else{
	            	parent.Public.tips({type: 1, content : data.message});
	            }
	            dialog.close();
                return;
            }
        }
        
        function popCancel(item, dialog)
        {
            dialog.close();
        }
	</script>
</head>
<body>
	<div class="cata_filter" id="cata_filter_id">
		<ul>
	  		<li>
				<dl>
    				<dd>
    					<a onclick="reload()" >重新加载</a>
    				</dd>
    				<dd>
    					<a onclick="addTreeItem()" >增加节点</a>
    				</dd>
    				<dd>
				   		<a onclick="updateTreeItem()" >更新节点</a>
    				</dd>
    				<dd>
        				<a onclick="removeTreeItem()" >删除节点</a>					
    				</dd>
				</dl>
	  		</li>			
		</ul>
	</div>
	<hr />
	<div id="menuTree" ></div>
</body>
</html>
﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="common/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" ></meta>
	<title>我的主页</title>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/index.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/ui.css">
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/main.css"/>
	<link rel="stylesheet" type="text/css" href="${path}/resources/css/base.css">
	<script src="${path}/resources/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
	<script src="${path}/resources/js/config.js" type="text/javascript" ></script>
	<script src="${path}/resources/js/cnDateFn.js" type="text/javascript"></script>
	<script src="${path}/resources/echarts/echarts.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var greetings = "";
			var cur_time = new Date().getHours();
			if(cur_time >= 0 && cur_time <= 4 ) {
				greetings = "已经夜深了，请注意休息";
			} else if (cur_time > 4 && cur_time <= 7 ) {
				greetings = "早上好";
			} else if (cur_time > 7 && cur_time < 12 ) {
				greetings = "上午好";
			} else if (cur_time >= 12 && cur_time <= 18 ) {
				greetings = "下午好";
			} else {
				greetings = "晚上好";
			};
			var greetObj = $("#greetings");
			var userObj = $("#username");
			
			greetObj.text(greetings);
			userObj.text(parent.SYSTEM.realName);
			
			$("#search").click(function(){
				search();
			});
		});	
	</script>
</head>
<body>
	<div id="hd" class="hd">
		<p class="alt-today font_13">
			 <img alt="" src="${path}/resources/images/icn_date.gif" width="14" height="16" />
             <span>
                 <script type="text/javascript">
                     RunGLNL();
                 </script>
             </span>
		</p>
		<p class="ht_10"></p>
	  	<p class="welcome">
	  		<img alt="" src="${path}/resources/images/icn_user_gray.png" width="14" height="16" />
		  	<strong><span id="greetings">您好</span>，<span id="username">管理员</span>！</strong>
		  	<%-- 维护<a data-tabid="khlb" data-tabTxt="客户列表" data-parentOpen="true" rel="pageTab"  href="${path}/customer/toList">「资产报损」、</a>
		  	<a data-tabid="dwlb" data-tabTxt="单位列表" data-parentOpen="true" rel="pageTab" href="${path}/company/toList">「资产调拨」</a>信息。 --%>
		  	
	  	</p>
	</div>
	<div id="bd" class="clearfix" >
		<div class="col-main">
		    <div class="main-wrap cf">
		    
		      <!-- <div class="m-top">
		      	 <form onsubmit="return search();" method="post">
			      	 <div class="storages-search">
			      	 <label for="">资产名称:</label>
			      	 <span class="ui-search"><input type="text" name="contractName" id="contractName" class="ui-input" /></span>
			      	 <input type="submit" class="ui-btn" value="查 询" /></div>
		      	</form>
		      </div> -->
		      <%-- <ul class="quick-links">
		        <li class="contract-huiqian">
		        	<a data-tabid="" data-tabTxt="资产信息" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/assetinf/toList">
		        		<span></span>资产信息
	        		</a>
		        </li>
		        <li class="division-edit">
		        	<a data-tabid="" data-tabTxt="资产名称" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/assetnam/toList">
		        		<span></span>资产名称
	        		</a>
		        </li>
		        <li class="fund-transfers">
		        	<a data-tabid=""  data-tabTxt="资产类别" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/assetcla/toList">
		        		<span></span>资产类别
		        	</a>
		        </li>
		        <li class="statistics-funds">
		        	<a data-tabid="" data-tabTxt="资产购置" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/assetpurchaseapplication/toList">
		        		<span></span>资产购置
		        	</a>
		        </li>
		        <li class="manufacturer-list">
		        	<a data-tabid="" data-tabTxt="资产报损" data-parentOpen="true" rel="pageTab" href="${path }/assetmanage/assetdamage/toList">
		        		<span></span>资产报损
		        	</a>
		        </li>
		        <li class="user_list">
		        	<a data-tabid="" data-tabTxt="资产维护" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/maintenancerecord/toList">
		        		<span></span>资产维护
		        	</a>
		        </li>
		        <li class="feedback">
		        	<a data-tabid="" data-tabTxt="资产分配" data-parentOpen="true" rel="pageTab" href="${path}/assetmanage/assetchange/toList"><span></span>资产分配</a>
		        </li>
		      </ul> --%>
		      <div id="main" style="width: 100%;height:450px;"></div>
		      <script type="text/javascript">
		        // 基于准备好的dom，初始化echarts实例
		        var myChart = echarts.init(document.getElementById('main'));
		        //读取图例json
		        parent.Public.ajaxPost("${path}/assetmanage/assetinf/getJsonForChartsLegend",null,function(msglegend){
		        	//写回调函数
		        	msglegend=eval(msglegend);
		        	var legend,data;
		        	if(msglegend.state){
		        		//图例json字符串转对象
		        		legend= JSON.parse(msglegend.param) ;
				        //在图例回调中读取数据json
				        parent.Public.ajaxPost("${path}/assetmanage/assetinf/getJsonForChartsData",null,function(msgdata){
				        	//写回调函数
				        	msgdata=eval(msgdata);
				        	if(msgdata.state){
				        		var data=msgdata.rows;
				        		
				        		// 指定图表的配置项和数据
						        var option = {
									title : {
								        text: '资产类型占比',
								        //subtext: '纯属虚构',
								        x:'center'
								    },
								    tooltip : {
								        trigger: 'item',
								        formatter: "{a} <br/>{b} : {c} ({d}%)"
								    },
								    legend: {
								        orient: 'vertical',
								        left: 'left',
								        data: legend,
								    },
								    series : [
								        {
								            name: '数量',
								            type: 'pie',
								            radius : '55%',
								            center: ['50%', '60%'],
								            data: data,
								            itemStyle: {
								                emphasis: {
								                    shadowBlur: 10,
								                    shadowOffsetX: 0,
								                    shadowColor: 'rgba(0, 0, 0, 0.5)'
								                }
								            }
								        }
								    ]
						        };
						
						        // 使用刚指定的配置项和数据显示图表。
						        myChart.setOption(option);
				        	}else{
				        		parent.Public.tips({type: 1, content : "读取数据失败"});
				        	}
				        });
		        	}else{
		        		parent.Public.tips({type: 1, content : "读取图例失败"});
		        	}
		        });
		        
		        
		        
		        
		    </script>
		    </div>
		</div>
		<div class="col-extra">
		  <div class="extra-wrap">
		    <h2>统计查询</h2>
		    <div class="list">
		      <ul>
		      	<li>
		      		<a href="${path}/report/contractCountByModule" rel="pageTab" data-tabid="httj" data-tabTxt="查看统计" data-parentOpen="true">敬请期待</a>
		      	</li>
		        <li>
		        	<a href="${path}/fund/list" rel="pageTab" data-tabid="sfkcx" data-tabTxt="查看统计" data-parentOpen="true">查看统计</a>
		        </li>
		      	<li>
		      		<a href="${path}/gongdan/toList" rel="pageTab" data-tabid="sgdlb" data-tabTxt="查看统计" data-parentOpen="true">查看统计</a>
		      	</li>
		      	<li>
		      		<a href="${path}/report/bzgctj" rel="pageTab" data-tabid="bzgctj" data-tabTxt="查看统计" data-parentOpen="true" >查看统计</a>
		      	</li>
		      	<li>
		      		<a href="${path}/report/toCompany" rel="pageTab" data-tabid="fbdwtj" data-tabTxt="查看统计" data-parentOpen="true">查看统计</a>
		      	</li>
		        <li>
		        	<a href="${path}/report/taizhang" rel="pageTab" data-tabid="rwdjtz" data-tabTxt="查看统计" data-parentOpen="true">查看统计</a>
		       	</li>
		        <li>
		        	<a href="${path}/report/qingdan" rel="pageTab" data-tabid="gcxmqd" data-tabTxt="查看统计" data-parentOpen="true" >查看统计</a>
		        </li>
		        
		      </ul>
		    </div>
		  </div>
		</div>
	</div>
	<script type="text/javascript">
		Public.pageTab();	
		function search(){
			var name= $("#contractName").val();
			if(parent.tab.isTabItemExist('htzhcx')){
				parent.tab.removeTabItem('htzhcx');
			}
			parent.Public.addTab('htzhcx',"合同信息综合查询","${path}/report/toContractQuery?contractName="+name);
			return false;
		}
	</script>
</body>
</html>
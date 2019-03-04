<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8" />
<title>TemChartforWeek</title>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
</head>
<body>
	<div id="container" style="width: 80%; height: 60%; margin: 0 auto">
	</div>
		<script language="JavaScript">
		$(document).ready(function() {
		   credits: {  
	       	enabled: false     //不显示LOGO 
	       }  
		   var title = {
		      text: '一周体温变化图'   
		   };
		   var subtitle = {
		      text: ''
		   };
		   var xAxis = {
		      categories: ['Sun','Mon', 'Tues', 'Wed', 'Thur', 'Fri', 'Satur']
		   };
		   var yAxis = {
		      title: {
		         text: 'Temperature (\xB0C)'
		      },
		      plotLines: [{
		         value: 0,
		         width: 1,
		         color: '#808080'
		      }]
		   };   
		
		   var tooltip = {
		      valueSuffix: '\xB0C'
		   }
		
		   var legend = {
		      layout: 'vertical',
		      align: 'right',
		      verticalAlign: 'middle',
		      borderWidth: 0
		   };
		
		   var series =  [
		      {
		         name: 'Tokyo',
		         data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2
		            ]
		      }
		      
		   ];
		
		   var json = {};
		
		   json.title = title;
		   json.subtitle = subtitle;
		   json.xAxis = xAxis;
		   json.yAxis = yAxis;
		   json.tooltip = tooltip;
		   json.legend = legend;
		   json.series = series;
		
		   
		   $('#container').highcharts(json);
		});
		</script>
	</body>
</html>

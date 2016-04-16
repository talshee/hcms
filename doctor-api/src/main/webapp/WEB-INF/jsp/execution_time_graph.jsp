<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <script type="text/javascript"
          src="https://www.google.com/jsapi?autoload={
            'modules':[{
              'name':'visualization',
              'version':'1',
              'packages':['corechart']
            }]
          }"></script>

    <script type="text/javascript">
    google.load('visualization', '1', {packages: ['corechart', 'line']});
    google.setOnLoadCallback(drawBasic);

    function drawBasic() {

          var data = new google.visualization.DataTable();
          data.addColumn('datetime', 'X');
          data.addColumn('number', 'Execution Time');

          data.addRows([
			<c:forEach items="${performanceDataList}" var="entry">
			[new Date('${entry.value.executedTimestamp}'), ${entry.value.jobExecutionTime} ],
			</c:forEach>
          ]);

          var options = {
            hAxis: {
              title: 'Timestamp'
            },
            vAxis: {
              title: 'Execution Time'
            }
          };

          var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

          chart.draw(data, options);
        }
    </script>
  </head>
  <body>
  	<h1>Allocator Execution Time Monitor</h1>
    <div id="chart_div" style="width: 1200px; height: 900px"></div>

  </body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<c:set var="context" value="${pageContext.request.contextPath}" />
<link href="${context}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${context}/css/starter-template.css" rel="stylesheet">
<body>

    <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="#">P</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link weatherLink" href="#">날씨</a>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
        </form>
      </div>
    </nav>

    <div class="container background-cloud">

		<div class="starter-template">
			<h1>서울 영등포구 당산동6가</h1>
			<p class="lead">
				<img src="${context}/css/weather_icons/01.png">
			</p>
			<div class="table-responsive">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>현재상태</th>
							<th>체감온도</th>
							<th>강수량</th>
							<th>풍속</th>
							<th>최고·최저</th>
							<th>습도</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>맑음</td>
							<td>15˚</td>
							<td>0.0mm</td>
							<td>14.0ms</td>
							<td>17˚/13˚</td>
							<td>65%</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="${context}/bootstrap/assets/js/vendor/popper.min.js"></script>
    <script src="${context}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${context}/scripts/main.js"></script>
    <script type="text/javascript">
		$(function() {
			$.ajax(
			{	
				url : "http://apis.skplanetx.com/weather/current/hourly?",
				data:{
					"version":"1",
					"city":"서울",
					"county":"영등포구",
					"village":"당산동6가",
					"appKey" :"b7064c20-31ce-3adb-af03-80faf0315ad9"
				},
				dataType : 'json',
				success : function(data) {
					var weather       = data.weather.hourly[0];
					var weatherIcon   = weather.sky.code;
					var weatherName   = weather.sky.name;
					var ppitation     = weather.precipitation.sinceOntime;
					var ppitationType = weather.precipitation.type;
					var tperaturetc   = weather.temperature.tc;
					var tperaturetmax = weather.temperature.tmax;
					var tperaturetmin = weather.temperature.tmin;
					var humidity      = weather.humidity;
					var wind          = weather.wind.wspd;
					var time          = c.getPmAm();
					var icon          = null;
					switch(weatherIcon){
						case "SKY_O00": icon = 38; break;
						case "SKY_O01": icon = time == "AM" ? "01" : "08";   break;
						case "SKY_O02": icon = time == "AM" ? "02" : "09";   break;
						case "SKY_O03": icon = time == "AM" ? "03" :   10;   break;
						case "SKY_O04": icon = time == "AM" ? 12   :   40;   break;
						case "SKY_O05": icon = time == "AM" ? 13   :   41;   break;
						case "SKY_O06": icon = time == "AM" ? 14   :   42;   break;
						case "SKY_O07": icon = 18; break;
						case "SKY_O08": icon = 21; break;
						case "SKY_O09": icon = 32; break;
						case "SKY_O10": icon = 4;  break;
						case "SKY_O11": icon = 29; break;
						case "SKY_O12": icon = 26; break;
						case "SKY_O13": icon = 27; break;
						case "SKY_O14": icon = 28; break;
					}
					$('.lead > img').attr('src',"../../css/weather_icons/"+icon+".png");
					$('table.table.table-striped tr > td')[0].innerHTML = weatherName;
					$('table.table.table-striped tr > td')[1].innerHTML = parseInt(tperaturetc)+"˚";
					$('table.table.table-striped tr > td')[2].innerHTML = parseInt(ppitation)+"mm";
					$('table.table.table-striped tr > td')[3].innerHTML = wind+"ms";
					$('table.table.table-striped tr > td')[4].innerHTML = parseInt(tperaturetmax) + "˚/" +parseInt(tperaturetmin)+"˚";
					$('table.table.table-striped tr > td')[5].innerHTML = parseInt(humidity);
					
				},
				error : function(e){
					console.log(e);
				}
			});
		});
		
		
		$.ajax({
			url: 'https://fcc-weather-api.glitch.me/api/current?lat=1&lon=2',
			success: function(e){
				console.log(e);
			}
					
		})
	</script>
</body>
</html>
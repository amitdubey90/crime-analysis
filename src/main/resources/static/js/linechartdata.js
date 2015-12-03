var month=['January','February','March','April','May','June','July','August','September','October','November','December'];
var crimecountarr =[];

app = angular.module("myapp",[])

app.controller("MonthlyCountController", function($scope,$http) {
 //$http.get("http://demo0899463.mockable.io/crimecount").success(function(data) {
    $http.get("http://localhost:8080/getCount/byMonth").success(function(data) {
      $scope.data = data;
      for (var i = 0; i < $scope.data.monthlyCount.length; i++) {
       var crimemonthInt=$scope.data.monthlyCount[i].monthInt
       var crimecount=$scope.data.monthlyCount[i].count
       console.log(crimecount)
          crimecountarr.push(crimecount)
      }
            var data = {
                labels: month,
                datasets: [
                    {
                        label: "Monthly crime report",
                        fillColor: "rgba(220,220,220,0.2)",
                        strokeColor: "rgba(220,220,220,1)",
                        pointColor: "rgba(220,220,220,1)",
                        pointStrokeColor: "#fff",
                        pointHighlightFill: "#fff",
                        pointHighlightStroke: "rgba(220,220,220,1)",
                        data: crimecountarr
                    }
                ]
            };

            var ctx = document.getElementById("myChart").getContext("2d");
            var myLineChart = new Chart(ctx).Line(data);
     }

 );
});


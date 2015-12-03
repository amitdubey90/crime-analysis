var crimecountarr=[];
var crimenamearr=[];
app = angular.module("myapp",[])

app.controller("CrimeCountController", function($scope,$http) {
 //$http.get("http://demo0899463.mockable.io/crimecount").success(function(data) {
    $http.get("http://localhost:8080/getCount/byType").success(function(data) {
      $scope.data = data;
      //console.log($scope.data.coordinates[0].latitude)
      for (var i = 0; i < $scope.data.crime.length; i++) {
       var crimetype=$scope.data.crime[i].type
       var crimecount=$scope.data.crime[i].count
       //console.log(latitude)
       console.log(crimetype+" "+crimecount)
       crimecountarr.push(crimecount)
       crimenamearr.push(crimetype)
       //  $scope.arr=arr
      }
      console.log("data retrieved "+crimecountarr)
      console.log("data retrieved "+crimenamearr)

      var barData = {
       labels: crimenamearr,
       datasets: [
        {
         label: '2010 crime #',
         fillColor: '#382763',
         data: crimecountarr
        }
       ]
      };
      context = document.getElementById('graph1').getContext('2d');
      clientsChart = new Chart(context).Bar(barData);
     }

 );
});

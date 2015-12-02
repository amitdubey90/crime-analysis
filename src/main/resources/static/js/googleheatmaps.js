var map, heatmap;
arrt=[];
crimecountarr=[];
crimenamearr=[];
app = angular.module("myapp", [])

app.controller("FirstController", function($scope,$http) {
   $scope.helloTo = {};
   $scope.helloTo.title = "AngularJS";

   $http.get("http://demo5924853.mockable.io/coordinates")
       .success(function(data) {

         $scope.data = data;
         var arr= [];
         //console.log($scope.data.coordinates[0].latitude)
         for (var i = 0; i < $scope.data.coordinates.length; i++) {
           var latitude=$scope.data.coordinates[i].latitude
           var longitude=$scope.data.coordinates[i].longitude
           //console.log(latitude)
           console.log(latitude+" "+longitude)
           var temp=new google.maps.LatLng(latitude,longitude)
           arr.push(temp);
          //  $scope.arr=arr
           }
           console.log("data retriecedl")
           arrt = arr;
           console.log(arrt)
           initMap();
       });
});


function initMap() {
    console.log("initMap")
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: {lat: 37.775, lng: -122.434},
        mapTypeId: google.maps.MapTypeId.SATELLITE
    });
    heatmap = new google.maps.visualization.HeatmapLayer({
//data: getPoints(),
        data: arrt,
        map: map
    });
}

function toggleHeatmap() {
    heatmap.setMap(heatmap.getMap() ? null : map);
}

function changeGradient() {
    var gradient = [
        'rgba(0, 255, 255, 0)',
        'rgba(0, 255, 255, 1)',
        'rgba(0, 191, 255, 1)',
        'rgba(0, 127, 255, 1)',
        'rgba(0, 63, 255, 1)',
        'rgba(0, 0, 255, 1)',
        'rgba(0, 0, 223, 1)',
        'rgba(0, 0, 191, 1)',
        'rgba(0, 0, 159, 1)',
        'rgba(0, 0, 127, 1)',
        'rgba(63, 0, 91, 1)',
        'rgba(127, 0, 63, 1)',
        'rgba(191, 0, 31, 1)',
        'rgba(255, 0, 0, 1)'
    ]
    heatmap.set('gradient', heatmap.get('gradient') ? null : gradient);
}

function changeRadius() {
    heatmap.set('radius', heatmap.get('radius') ? null : 20);
}

function changeOpacity() {
    heatmap.set('opacity', heatmap.get('opacity') ? null : 0.2);
}

function getPoints(){


}
// Heatmap data: 500 Points
function getPoints1() {
    return [
        new google.maps.LatLng(37.782551, -122.445368),
        new google.maps.LatLng(37.782745, -122.444586),
        new google.maps.LatLng(37.782842, -122.443688),
        new google.maps.LatLng(37.782919, -122.442815),
        new google.maps.LatLng(37.782992, -122.442112),
        new google.maps.LatLng(37.783100, -122.441461),
        new google.maps.LatLng(37.783206, -122.440829)
    ];
}

//********************************* graph1 ********************************************************

app.controller("SecondController", function($scope,$http) {
    $http.get("http://demo0899463.mockable.io/crimecount").success(function(data) {
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


//******************** graph 2 ***********************************************************

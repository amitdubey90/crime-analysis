var map, heatmap;
arrt=[];
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
           console.log("data retrieved")
           arrt = arr;
           console.log(arrt)
           initMap(latitude,longitude);
       });
});


function initMap(latitude, longitude) {
    console.log("initMap")
    map = new google.maps.Map(document.getElementById('map'), {
        zoom: 13,
        center: {lat: latitude, lng: longitude},
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


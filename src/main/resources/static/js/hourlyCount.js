$(function () {
    $.getJSON('http://localhost:8080/getCount/byHour', function (rawData) {

        data = [];
        rawData.hourly.map(function(val) {
            data.push(val.count)
            return 0; 
        });

        console.log(data)

        $('#container').highcharts({
            chart: {
                zoomType: 'x'
            },
            title: {
                text: 'Incident Count By Hour'
            },
            subtitle: {
                text: document.ontouchstart === undefined ?
                        'Click and drag in the plot area to zoom in' : 'Pinch the chart to zoom in'
            },
            xAxis: {
                type: 'linear'
            },
            yAxis: {
                title: {
                    text: 'Count'
                }
            },
            legend: {
                enabled: false
            },
            plotOptions: {
                area: {
                    fillColor: {
                        linearGradient: {
                            x1: 0,
                            y1: 0,
                            x2: 0,
                            y2: 1
                        },
                        stops: [
                            [0, Highcharts.getOptions().colors[0]],
                            [1, Highcharts.Color(Highcharts.getOptions().colors[0]).setOpacity(0).get('rgba')]
                        ]
                    },
                    marker: {
                        radius: 2
                    },
                    lineWidth: 1,
                    states: {
                        hover: {
                            lineWidth: 1
                        }
                    },
                    threshold: null
                }
            },

            series: [{
                type: 'area',
                name: 'Hourly Crime Count',
                data: data
            }]
        });
    });
});
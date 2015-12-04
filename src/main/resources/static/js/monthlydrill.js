$(function () {
    // Create the chart
    result = [];
    drillArray = [];
    $.getJSON('http://localhost:8080/getCount/byMonthForDrill', function (data) {
        quarter = 1;
        var monthNames = ["January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"];

        console.log(JSON.stringify(data))
        var monthsums = [0,0,0,0,0,0,0,0,0,0,0,0,0];
        var monthlytypecount = {
            "1":{}, "2":{}, "3":{}, "4":{}, "5":{}, "6":{},
                            "7":{}, "8":{}, "9":{}, "10":{}, "11":{}, "12":{}
        }
        totalSum = 0;
        for ( i = 0; i< data.length; i = i+ 1) {
            totalSum += data[i].count;
            monthsums[data[i].month] += data[i].count;
            if(monthlytypecount[data[i].month].hasOwnProperty(data[i].type)) {
                monthlytypecount[data[i].month][data[i].type] += data[i].count;
            } else {
                monthlytypecount[data[i].month][data[i].type] = data[i].count;
            }
        }
        console.log(monthlytypecount)
        for ( i = 0; i< 12; i = i+ 1) {    
            // innerSum = 0;
            // for(j = i; j< i+3; j++) {
            //     innerSum += data[j].unitsSold
            // }

            // for(j = i; j< i+3; j++) {
            //     drillArray.push([monthNames[j], data[j].unitsSold/innerSum*100])
            // }

            temp = {
                    name : monthNames[i],
                    y : monthsums[i+1]/totalSum*100,
                    drilldown: monthNames[i]
                };
            
            result.push(temp);
            innerSum = 0;
        }

        console.log(JSON.stringify(result))
        $('#container3').highcharts({
        chart: {
            type: 'pie'
        },
        title: {
            text: 'Monthly crime percentage for 2012'
        },
        subtitle: {
            text: 'Click the slices to see type details'
        },
        plotOptions: {
            series: {
                dataLabels: {
                    enabled: true,
                    format: '{point.name}: {point.y:.1f}%'
                }
            }
        },

        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
        },
        series: [{
            name: 'Brands',
            colorByPoint: true,
            data: result
        }],
        drilldown: {
            series: [{
                name: 'January',
                id: 'January',
                data: monthlytypecount["1"]
            }, {
                name: 'Quarter 2',
                id: 'Quarter 2',
                data: drillArray.splice(0,3)
            }, {
                name: 'Quarter 3',
                id: 'Quarter 3',
                data: drillArray.splice(0,3)
            }, {
                name: 'Quarter 4',
                id: 'Quarter 4',
                data: drillArray.splice(0,3)
            }]
        }
    });
    });
    
});
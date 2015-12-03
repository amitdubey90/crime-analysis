var diameter = 960,
    format = d3.format(",d"),
    color = d3.scale.category20c();

var bubble = d3.layout.pack()
    .sort(null)
    .size([diameter, diameter])
    .padding(1.5);

var svg = d3.select("#bubble").append("svg")
    .attr("width", diameter)
    .attr("height", diameter)
    .attr("class", "bubble");

$.getJSON("http://localhost:8080/getCount/byType", function(rawData){
    console.log("response from api "+JSON.stringify(rawData))

    data = {children: []};
    rawData.crime.map(function(val){
        data.children.push({packageName: val.type, className: val.type, value: val.count})
    });

    console.log('filtered data '+data);

    var node = svg.selectAll(".node")
        .data(bubble.nodes(data)
            .filter(function(d) { return !d.children; }))
        .enter().append("g")
        .attr("class", "node")
        .attr("transform", function(d) { return "translate(" + d.x + "," + d.y + ")"; });

    node.append("title")
        .text(function(d) { return d.className + ": " + format(d.value); });

    node.append("circle")
        .attr("r", function(d) { return d.r; })
        .style("fill", function(d) { return color(d.packageName); });

    node.append("text")
        .attr("dy", ".3em")
        .style("text-anchor", "middle")
        .text(function(d) { return d.className.substring(0, d.r / 3); });
});
var ctx = document.getElementById("bubble");
d3.select("#bubble").style("height", diameter + "px");

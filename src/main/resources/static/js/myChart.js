/**
 * 
 */
// For a pie chart

var chartdatastr=documenthtml(chartdata);
var chartjsonarray=JSON.parse(chartdatastr);
var chartjsonlength=chartjsonarray.length;
var numericdata=[];
var labeldata=[];

for(var i=0; i<chartjsonlength; i++){
	numericdata[i]=chartjsonarray[i].status;
	labeldata[i]=chartjsonarray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labeldata,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ['#3e95cd','#8e5ea2','#3cba9f'],
           
            data: numericdata,
        }]
    },
    options: {
    	title:{
    		display:true,
    		text:'project statuses'
    	}
    }
});

function documenthtml(html){
	var txt=document.createElement("textarea");
	txt.innerHTML=html;
	return txt.value;
}

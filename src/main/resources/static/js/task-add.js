$(function(){
	var url = '/task/getById?id=8';
	$.get(url,function(data){
		console.log(data);
	});
});
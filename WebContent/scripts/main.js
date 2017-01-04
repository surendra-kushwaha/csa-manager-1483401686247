$(document).load(function () {
	
	alert('');
	$('.priority').each(function () {
		if($(this).text()=='Medium'){
		  $(this).addClass('med');
		 } else if($(this).text()=='Low') {
		$(this).addClass('low');
		}else if($(this).text()=='High') {
		$(this).addClass('high');
		} else{
		$(this).addClass('normal');
		};
	});
});
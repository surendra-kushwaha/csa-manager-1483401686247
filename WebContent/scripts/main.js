/*$(document).load(function () {
	$(".success-msg").fadeIn();
    setTimeout($(".success-msg").fadeOut(), 15000);
});*/

function changes() {
	alert('');
	$('.priority').each(function() {
		var cls = 'nrm';
		switch ($(this).text()) {
		case 'Critical':
			cls = 'crt';
			break;
		case 'High':
			cls = 'hgh';
			break;
		case 'Low':
			cls = 'lw';
			break;
		default:
			cls = 'nrm';
		}
		$(this).addClass(cls);
	});
}
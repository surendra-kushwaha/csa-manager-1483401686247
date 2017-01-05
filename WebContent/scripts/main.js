/*$(document).load(function () {
	$(".success-msg").fadeIn();
    setTimeout($(".success-msg").fadeOut(), 13000);
});*/

function changes() {
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

function validate () {
	setTimeout(function() {
		$(".success-msg").fadeOut();
	}, 3000);
}

function feedbacks () {
	$('.borderless ul li a').on('click', function () {
		 $theSpan = $(this).children('span');
		 $theSiblings = $(this).parent('li').siblings();
		 if($theSpan.hasClass('actives')){
			$theSpan.removeClass('actives');
		 }else{
			$theSpan.addClass('actives');
		    $theSiblings.each(function () {
		      $(this).children('a').children('span').removeClass('actives');
		   });
		 }
	});
	
	$('.feedback-span a').on('click', function () {
		if($('.actives').length==4){
			$(".success-msg1").html('CSAT survey has been successfully completed.').fadeIn();
			setTimeout(function() {
				$(".success-msg1").fadeOut();
			}, 3000);
		}else{
			$(".success-msg1").html('Please provide the feedback for all options').addClass('errormsg1').fadeIn();
			setTimeout(function() {
				$(".success-msg1").removeClass('errormsg1').fadeOut();
			}, 3000);
		};
	});
}
function elementAction(i){
	switch(i){
	case "pageInputAdd" : /*메뉴관리 추가*/
		var input = $('<div class="col-lg-6"><div class="input-group"><span class="input-group-addon"> <input type="checkbox"></span> <input type="text" class="form-control"></div></div>');
		$('.card-body').prepend(input);
		break;
	case "pageSave" : /*메뉴관리 저장*/
		$('input[type="checkbox"]').each(function(i,e){
			if($(this).prop('checked')){
				var input = $(this).closest('.input-group-addon').next().val();
				if(input.length > 0 ){
					c.actionCallback({
						"type"    : "insert",
						"method"  : "insertTopMenu",
						"title"   : input,
						"menulv"  : 1,
						"menuid"  : i
					})
				}
			}
		})
		location.href="/admin";
		break;
	case "pageDelete" : /*메뉴관리 삭제*/
		$('input[type="checkbox"]').each(function(){
			if($(this).prop('checked')){
				var input = $(this).closest('.input-group-addon').next().val();
				if(input.length > 0 ){
					c.actionCallback({
						"type"    : "delete",
						"method"  : "deleteTopMenu",
						"title"   : input,
					})
				}
				$(this).closest('div').closest('div').remove();
			}
		});
		location.href="/admin";
		break;
	case "sidebarToggle" : /*화면관리 디자인툴*/
		$('.list-group > div').toggle();
		break;
	case "displaySave" : /*화면관리 저장*/
		c.htmlCallback(meta.sidebar,'builder','save',$('.contextDesinge').html());
		break;
	case "displayApply" : /*화면관리 반영*/
		c.htmlCallback(meta.sidebar,'builder','apply',$('.contextDesinge').html());
		break;
	case "displayModalSave" : /*display 팝업 화면 저장*/
		$.each($('.fr-element.fr-view'),function(){
			if($(this).text().length){
				var beforeClass = meta.display.className;
				var $meta_display = $(meta.display).closest('.in');
				if($meta_display.length != 0){
					$meta_display.val($(this).text());
					$meta_display.html($(this).html()).addClass(beforeClass);
					$meta_display.attr('value',$(this).text());										
				}else{
					$(meta.display).val($(this).text());
					$(meta.display).html($(this).html()).addClass(beforeClass);
					$($(meta.display)).attr('value',$(this).text());
					
					if($(meta.display).hasClass('in_act')){
						$($(meta.display)).attr('href',$('.type_link').val());
					}
				}

				return false;
			}
		});
		break;
	case "displayModalDelete" : /*display 팝업 화면 parent element 삭제*/
		$(meta.display).closest('.sct').remove();
		$('#displayModal_1').modal('hide');
		break;
	}


}
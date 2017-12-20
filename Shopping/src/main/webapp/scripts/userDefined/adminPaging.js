$(function(){
	/*페이징 처리시 상단메뉴 구성 #*/	
	var a = c.actionCallback({ "type" : "select", "method" : "selectTopMenu" });
	for(var i=0; i < a.length; i++){
		if(a[i].title){
			$('.card-body .col-lg-6').append('<div class="input-group"><span class="input-group-addon"> <input type="checkbox"></span> <input type="text" class="form-control" value="'+a[i].title+'"></div>');
			/*display 사이드 메뉴 구성 START*/
			$('.list-sidebar.bg-defoult').append('<li><a class="nav-label" href="#">'+a[i].title+'</a></li>');
			/*display 사이드 메뉴 구성 $*/
		}
	}
	/*페이징 처리시 상단메뉴 구성 $*/
	init();
	init_bind();
})
function init(){
	/* drag & drog 페이지 구성 #*/
	$( ".list-group > div" ).draggable({
		helper: "clone",
		snap: true,
		revert: "invalid"
	});
	/* drag & drog 페이지 구성 $*/
	/* html debug 설정 editor #*/
	try{
		$('#edit').froalaEditor({
		    toolbarButtons: ['bold', 'italic', 'underline', 'paragraphFormat', 'formatOL', 'formatUL', 'insertHTML', 'undo', 'redo', 'html']
		});
	}catch(e){
		
	}
	/* html debug 설정 editor $*/
}
function init_bind(){
	/*sct node Problems !#*/
	$('.sct > .sct').parent().addClass('redsct');
	/*sct node Problems !$*/

	$(".contextDesinge .sct").draggable({
		helper: "clone",
		snap: true,
		revert: "invalid"
	});
	$( ".contextDesinge * , .contextDesinge" ).droppable({
		accept: ".contextDesinge * , .contextDesinge , .sct",
		greedy: true,
		tolerance: "pointer",
		drop: function( event, ui ){
			if (!$( ui.draggable).hasClass( "list-group-item" )){$( ui.draggable ).detach(); $( ui.helper ).detach();};
			$(this).append($(ui.draggable).clone().removeAttr( 'style' ).removeClass("list-group-item redsct"));
			setTimeout(init_bind(), 200);
		}
	});
}
function modalStack(){
	if(  $(meta.nElement.target).hasClass("in") || $(meta.nElement.target).hasClass("del")
	   ||$(meta.nElement.target).hasClass("in_act")
	   ||$(meta.nElement.target).closest('.in , .del').length != 0){
		meta.display = meta.nElement.target;
		if(!$(meta.display).closest('.list-group-item').length){
			if($(meta.nElement.target).hasClass("in")){
				$('.type_in').show();
				$('.displayModalSave').show();
				$('.type_act').hide();
			}
			if($(meta.nElement.target).hasClass("del")){
				$('.type_in').hide();
				$('.displayModalSave').hide();
				$('.type_act').hide();
			}
			if($(meta.nElement.target).hasClass("in_act")){
				$('.type_in').show();
				$('.type_act').show();
				$('.displayModalSave').show();
			}
			$('#displayModal_1').modal({keyboard: false,show:true}).draggable({ handle: ".modal-header" });
			setTimeout(function(){
				$(meta.display).closest('.sct').addClass('redsct');
				$('#displayModal_1').on('hidden.bs.modal',function(){
					$(meta.display).closest('.sct').removeClass('redsct');
				});
			},200);

		}
	}
}
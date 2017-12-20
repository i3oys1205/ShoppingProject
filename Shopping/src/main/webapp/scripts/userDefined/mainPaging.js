$(function(){
	/*페이징 처리시 상단메뉴 구성 #*/	
	var a = c.actionCallback({ "type" : "select", "method" : "selectTopMenu" });
	for(var i=0; i < a.length; i++){
		if(a[i].title)
			$('#navbarsExampleDefault > ul.navbar-nav').append('<li class="nav-item"><a class="nav-link" href="#">'+a[i].title+'</a></li>');
	}
	/*페이징 처리시 상단메뉴 구성 $*/
})
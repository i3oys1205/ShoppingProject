var meta = {};
var O = function () { },
c = {
		ev : function(){
			if(meta.nElement.type === "click"){
				this.displaySetting();
				this.modalPopupSetting();
				if(meta.nElement.target.attributes["page"]){
					location.href = meta.nElement.target.attributes["page"].value;
				}else if(meta.nElement.target.attributes["action"]){
					elementAction(meta.nElement.target.attributes["action"].value);
				}
			}
		},
		getAmPm : function(){
			var date = new Date(); 
			var hour = date.getHours(); 
			var rtn;
			if (hour < 18){rtn = "AM";}else{rtn = "PM";}
			return rtn;
		},
		actionCallback : function(obj){
			var keyStr = "?actCB=1" , rtnData;
			for(var key in obj) {
				if(obj.hasOwnProperty(key)){ 
					keyStr += '&'+key+'='+obj[key];
				}
			}
			$.ajax({
				url:"action"+keyStr,dataType:"json",async:false,contentType : 'application/json; charset=utf-8',
				success:function(e){
					if(e)if(e[0].result === "201"){alert("저장성공");
					}else if(e[0].result === "202"){alert("삭제성공");}
					console.log(e);
					rtnData = e;
				},
				error:function(e){
					console.log(e);
				}
			})
			return rtnData;
		},
		htmlCallback : function(html,template,action,contents){
			$.ajax({url:"html",dataType:"html",async:true,type: "POST",
				data:{"html":html,"template":template,"action":action,"contents":contents},
				success:function(e){
					if(e == "200"){
						alert("저장성공");
					}else{
						o.setActiveHtml(e);	
						if(template == "builder"){
							$('.contextDesinge').html(e);
							init_bind();
						}else{
							$('.container-fluid.starter-template').html(e);
						}
					}
				},
				error:function(e){
					console.log(e);
				}
			})
		},
		displaySetting : function(){
			if(meta.className == "nav-item" || meta.className == "nav-link"){
				meta.nav = meta.text;
				$('li.nav-item , .nav-link').removeClass('active');
				$('li.nav-item:contains("'+meta.text+'") , .nav-link:contains("'+meta.text+'")').addClass('active');
				c.htmlCallback(meta.text,'view',null,null);
			}else if(meta.className == "nav-label"){
				meta.sidebar = meta.text;
				$('.list-sidebar.bg-defoult > li').removeClass('active');
				$('.list-sidebar.bg-defoult > li:contains("'+meta.text+'")').addClass('active');
				c.htmlCallback(meta.text,'builder',null,null);
			}
		},
		modalPopupSetting : function(){
			if( typeof modalStack == 'function' )
				modalStack();
		}
};
O.prototype = {
		setActiveElement : function(i){
			if(i.hasOwnProperty('target')){
				meta.nElement  = i;
				meta.className = meta.nElement.target.className;
				meta.text      = meta.nElement.target.text;
			}
			return c.ev();
		},
		setActiveHtml : function(i){
			meta.activeHtml = i;
		},
};

$(function(){

	$(document).click(function(i){
		o.setActiveElement(i);
	})
})

var o = new O();
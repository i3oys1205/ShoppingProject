var meta = {};
var O = function () { },
c = {
	ev : function(){
		/* feedback:attr information or change */
		if(meta.nElement.type === "click"){
			if(meta.className === "navbar-brand"){
				location.reload();
			}
		}
	},
	getPmAm : function(){
		var date = new Date(); 
		var hour = date.getHours(); 
		var rtn;
		if (hour < 18){
			rtn = "AM";
		}else{
			rtn = "PM";
		}
		return rtn;
	}
};
O.prototype = {
	setActiveElement : function(i){
		if(i.hasOwnProperty('target')){
			meta.nElement  = i;
			meta.className = meta.nElement.target.className;
		}
		return c.ev();
	}
};

$(function(){
	$(document).click(function(i){
		o.setActiveElement(i);
	})
})

var o = new O();

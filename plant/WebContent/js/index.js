$('.carousel').carousel({
  interval: 500,
  pause: "hover"
});

/*$('#navigationBar a').click(function (e) {
          e.preventDefault()
          $(this).tab('show')
        })*/

window.onload = function(){

        var oNav = document.getElementById('nav');
        var aLi  = oNav.getElementsByTagName('a');

        for( var i = aLi.length; i--;){

                aLi[i].onclick = function(){
                         for( var i = aLi.length; i--;){
                                 aLi[i].className = '';
                         }
                         this.className = 'active';
                }
        }
}

$(function() {
    $("#toTop").scrollToTop(1000);
});

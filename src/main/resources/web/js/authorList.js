/**
 * Created by Алексей on 18.01.2016.
 */
$(document).ready(function(){
    var authorJSON=$.getJSON("ajax/authorJSON.json", {},function(json) {
        var row='';
        for (var i in json){
            row+='<tr class="author" id="author-"+json[i].id><td>'+json[i].name+'</td><td>'+json[i].surname+'</td><td>'+json[i].country+'</td></tr>';
        }
        $("#authorList").html(row);
    })
})
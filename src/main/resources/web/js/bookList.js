/**
 * Created by Алексей on 18.01.2016.
 */
$(document).ready(function(){
    $('#author').click(function() {
        $.getJSON("ajax/bookJSON.json",$(this).id , function (json) {
            var row = '';
            for (var i in json) {
                row += '<tr class="book" id="book-"+json[i].id><td>' + json[i].name + '</td><td>' + json[i].genre + '</td></tr>';
            }
            $("#list").html(row);
        })
    })
})
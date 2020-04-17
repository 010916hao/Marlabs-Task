$(document).ready(function() {
	
	$.ajax({
	
		url: "https://api.github.com/users"
		
	}).then(function(data) {
		
		//console.log(data);
		var table = $("#usersTable");
		var contents = "";
        var followers = "Click Please";
		$.each(data, function(idx) {
            contents +=  "<tr>";
            contents += "<td>" + data[idx].id + "</td>";
            contents += "<td>" + data[idx].login + "</td>";
            contents += "<td>" + data[idx].followers_url + "</td>";
            contents += "<td onclick='btn(this)'>" + followers + "</td>";
            contents += "<td> <img src='" + data[idx].avatar_url + "' width=50 height=50 /></td>";
            contents += "</tr>";
		});

		table.append(contents);
		
	});
	
});

function btn(obj) {
    console.log($(obj).prev().html());

    $.getJSON($(obj).prev().html(), function(json) {
        $(obj).html(json.length);
    });
}
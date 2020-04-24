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
           // contents += "<td>" + data[idx].id + "</td>";
            contents += "<td onclick='btn(this)'>" + data[idx].login + "</td>";
            contents += "<td>" + data[idx].followers_url + "</td>";
//            contents += "<td onclick='btn(this," + data[idx].followers_url + ")'>" + followers + "</td>";
            contents += "<td></td>";
//            contents += "<td> <img src='" + data[idx].avatar_url + "' width=50 height=50 /></td>";
            contents += "</tr>";
		});

		table.append(contents);
		
	});
	
});

function btn(url) {
   // console.log($(obj).prev().html());
	
	console.log(url);
    $.getJSON($(url).next().html(), function(json) {
    	$(url).next().next().html("");
    	for (var i = 0; i < json.length; i++) {
    		$(url).next().next().append("<td> <img src='" + json[i].avatar_url + "' width=20 height=20 /></td>");
    	}
        
    });
}
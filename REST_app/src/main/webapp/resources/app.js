var guitar_from_server;

function Guitar()
{
this.name;
this.firm;
this.tuning;
this.strings;
}

function get_guitars()
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/guitars' ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	display_guitars(data);
        console.log(JSON.stringify(data));

    }
  });


}


function get_guitar(id)
{

 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/guitar/' + id ,
    type: "GET",
    dataType: 'json',
    success: function(data) {
    	guitar_from_server = data;
    	display_guitar(data);
        console.log(JSON.stringify(data));

    }
  });


}


function save_guitar()
{
	
	guitar_from_server.name=document.forms[0].name.value;
	guitar_from_server.firm=document.forms[0].firm.value;
	guitar_from_server.tuning=document.forms[0].tuning.value;
	guitar_from_server.strings=document.forms[0].strings.value;
		
var jsonData = JSON.stringify(guitar_from_server); 
$.ajaxSetup({ cache: false });
$.ajax({

    url: 'service/guitar/' + guitar_from_server.id ,
    type: "POST",
    data: jsonData,
    dataType: 'json',
    contentType : 'application/json',
    success: function(data) {
    	show_message("Salvestatud");
        console.log(JSON.stringify(data));

    }
  });


}

function delete_guitar(id)
{
	
	$.ajaxSetup({ cache: false });
	$.ajax({
			url: 'service/guitar/' + id ,
			type: "DELETE",
			contentType : 'application/json',
			success: function(data) {
			show_message("Kustutatud");
			get_guitars();
			console.log(JSON.stringify(data));
			}
	});
}

function add_guitar()
{
	var guitar_to_server = new Guitar();
	guitar_to_server.name=document.forms[0].new_guitar_name.value;
	guitar_to_server.firm=document.forms[0].new_guitar_firm.value;
	guitar_to_server.tuning=document.forms[0].new_guitar_tuning.value;
	guitar_to_server.strings=document.forms[0].new_guitar_strings.value;

var jsonData = JSON.stringify(guitar_to_server);
$.ajaxSetup({ cache: false });
$.ajax({
	url: 'service/guitar/' ,
	type: "PUT",
	data: jsonData,
	dataType: 'json',
	contentType : 'application/json',
	success: function(data) {
		show_message("Sisestatud");
			console.log(JSON.stringify(data));
		get_guitars();
		}
 	});
}



function display_guitar(guitar)
{
	 var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td>Muutmine. Kitarri id: <b>" + guitar.id + "</b></td></tr>";

		out_data = out_data + "<tr><td>Nimi:</td><td><input type=text name=name value='" + guitar.name + "'></td></tr>";
		out_data = out_data + "<tr><td>Firma:</td><td><input type=text name=firm value='" + guitar.firm + "'></td></tr>";
		out_data = out_data + "<tr><td>Häälestus:</td><td><input type=text name=tuning value='" + guitar.tuning + "'></td></tr>";
		out_data = out_data + "<tr><td>Keelte arv:</td><td><input type=text name=strings value='" + guitar.strings + "'></td></tr>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:save_guitar()'>Salvesta</button></td>";
		out_data = out_data + "</table>";

	

	
	 $("#one_guitar").html(out_data);
}




function display_guitars(data)
{
	var out_data="";
	 out_data = out_data + "<table bgcolor=eeeeee><tr><td colspan=4>Kitarre kokku: <b>" + data.length + "</b></td></tr>";
	 for(var  i in data) {
   	  var guitar = data[i];
		out_data = out_data + "<tr><td>nimi:</td><td bgcolor=ffffff>" + guitar.name + "</td><td>firma:</td><td bgcolor=ffffff>" + guitar.firm + "</td>";
		out_data = out_data + "<td><button type='button' class='btn'  onClick='javascript:get_guitar(" + guitar.id + ")'>Vali</button></td>";
		
		out_data = out_data + "<td><button type='button' class='btn' onClick='javascript:delete_guitar(" + guitar.id + ")'>Kustuta</button></td></tr>";		
	 }
	 out_data = out_data + "</table>";

	
	 $("#guitars_table").html(out_data);
}


function show_message(message)
{
	
	 $("#msg_text").html(message);
}

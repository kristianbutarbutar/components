<script language="javascript">
//{"_label":"","_type":"","_name":"","other":"","_regex":"","_src":""},

var _usv = "http://localhost:8084/dynamicweb/ui/sys/column/update";
var _ush = "http://localhost:8084/dynamicweb/ui/sys/column/";
var _usrc = "http://localhost:8084/dynamicweb/ui/sys/column/";

var _form = {
		"fields" : [
					{"_label":"CID","_type":"HD","_name":"cid","other":"","_regex":"","_src":""},
		            {"_label":"Name","_type":"TX","_name":"name","other":"","_regex":"","_src":""},
		            {"_label":"Label","_type":"TX","_name":"label","other":"","_regex":"","_src":""},
		            {"_label":"Description","_type":"TA","_name":"description","other":"","_regex":"","_src":""},
		            {"_label":"Data Type","_type":"LS","_name":"dataType","other":"","_regex":"","_src":""},
		            {"_label":"Value URL","_type":"TX","_name":"url","other":"","_regex":"","_src":""},
		            {"_label":"Check Regex","_type":"TX","_name":"regex","other":"","_regex":"","_src":""}
		            ]
}

var _search = {
		"fields" : [
						{"_label":"Name","_type":"TX","_name":"_src_name","other":"","_regex":"","_src":""},
						{"_label":"Label","_type":"TX","_name":"_src_label","other":"","_regex":"","_src":""}
		            ]
}

var _btn_search = {"_label":"Search","_url":"","_regex":""}
var _btn_add = {"_label":"Add","_url":"","_regex":""}
var _btn_save = {"_label":"Save","_url":"","_regex":""}
var _btn_update = {"_label":"Update","_url":"","_regex":""}
var _btn_delete = {"_label":"Save","_url":"","_regex":""}

var _hd = function _hd(_obj){
	  return '<div class="form-group"><input type="hidden" id="'+_obj._name+'"></div>';
}

var _tx = function _tx(_obj){
	  return '<div class="form-group">'+
	    '<label for="'+_obj._name+'">'+_obj._label+'</label>'+
	    '<input type="text" class="form-control" id="'+_obj._name+'" placeholder="'+_obj._label+'"></div>';
}

var _ta = function _ta(_obj){
	  return '<div class="form-group">'+
	    '<label for="'+_obj._name+'">'+_obj._label+'</label>'+
	    '<textarea class="form-control" id="'+_obj._name+'" rows="3"></textarea></div>';
}

var _ls = function _ls(_obj){
	  return '<div class="form-group">'+
	    '<label for="'+_obj._name+'">'+_obj._label+'</label>'+
	    '<select class="form-control" id="'+_obj._name+'"></select>'+
	    '</div>';
}

var _element = function _getElement(_t, _obj){
	if(_t==='TX') return _tx(_obj);
	else if(_t==='TA') return _ta(_obj);
	else if(_t==='LS') return _ls(_obj);
	else if(_t==='HD') return _hd(_obj);
}

var _loadCard = function _showCard(_title){
	var _t ='<div id="_cardtitle" class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">'+
    '<h1 class="h5">'+_title+'</h5>'+
    '<div class="btn-toolbar mb-2 mb-md-0">'+
      '<button id="_add" type="button" class="btn btn-primary">Add</button>'+
    '</div>'+
  '</div>';
	$("#_content").html('<div id="_card" class="card"><div class="card-header">'+_t+'</div><div class="card-body"><div id="_cardcontent"></div></div></div>');
}
var _loadResult = function _showResultForm(_title){
	var _t ='<div id="_resulttitle" class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">'+
    '<h1 id="_rsttitle" class="h5">'+_title+'</h5>'+
    '<div class="btn-toolbar mb-2 mb-md-0">'+
      '<button id="_resultclose" class="btn btn-sm btn-outline-dark text-white">Close</button>'+
    '</div>'+
  '</div>';
	$("#_content").html($("#_content").html()+'<div id="_result" class="card"><div class="card-header bg-info">'+_t+'</div><div class="card-body"><div id="_resultcontent"></div></div></div>');
}

var _show_search = function(){
	var _t = "";
	for(i in _search.fields){
		_t = $("#_cardcontent").html() + _element(_search.fields[i]._type, _search.fields[i]); $("#_cardcontent").html(_t);
	}
	$("#_cardcontent").html(($("#_cardcontent").html() + '<div class="form-group"><button id="_search" type="button" class="btn btn-primary">Search</button></div>'));
}

var _showForm = function _showForm(){
	var _t = ""; $("#_resultcontent").html('');
	for(i in _form.fields){
		_t = $("#_resultcontent").html() + _element(_form.fields[i]._type, _form.fields[i]);
		$("#_resultcontent").html(_t);
	}
	$("#_resultcontent").html(($("#_resultcontent").html() + '<div class="form-group"><button id="_btnsave" onclick="_saveButton();void(0);" type="button" class="btn btn-primary">Save</button></div>'));
}

var _saveButton = function(){
	var _j = _getJsonFromForm();
	_doPost(_usv, _j, _preceiver);
}

var _getJsonFromForm = function(){
	var _j = {};
	for(i in _form.fields){
		_j[_form.fields[i]._name] =  document.getElementById(_form.fields[i]._name).value;
	}
	return _j;
}

var _update = function _showEdit(_id){
	var _p = "ID:"+_id+"/-";
	$('#_result').show();$("#_rsttitle").text("Form");
	_showForm(); _arecord(_ush, _p, __arecord);

}

var _arecord = function _getARecord(_url, _p, _prc){
	_doQ(_url, _p, _prc);
}

var __arecord = function __showARecord(_d){
	var _nid = "";
	_nid = "#"+_form.fields[0]._name; $(_nid).val(_d.list[0].cid);
	_nid = "#"+_form.fields[1]._name; $(_nid).val(_d.list[0].name);
	_nid = "#"+_form.fields[2]._name; $(_nid).val(_d.list[0].label);
	_nid = "#"+_form.fields[3]._name; $(_nid).val(_d.list[0].description);
	_nid = "#"+_form.fields[4]._name; $(_nid).append('<option value="'+_d.list[0].dataType+'">'+_d.list[0].dataType+'</option>');
	_nid = "#"+_form.fields[5]._name; $(_nid).val(_d.list[0].url);
	_nid = "#"+_form.fields[6]._name; $(_nid).val(_d.list[0].regex);
}

var _on200 = function(_cd){
	if(_cd == 200) _openmenu('column');
}

var _preceiver = function(_d){
	console.info(_d);
}

$(document).ready(function(){

	$("#_resultclose").click( function(){
			$('#_result').hide();
		}		
	);
	
	$("#_add").click( function(){
			$('#_result').show();$("#_rsttitle").text("Form");
			_showForm();
		}		
	);
	
	$("#_search").click( function(){ 
			var _p = ""; 
			var _n = $('#_src_name').val().match(/^\w/g);
			if(_n!=null) _p=$('#_src_name').val(); else _p="-";
			_n = $('#_src_label').val().match(/^\w/g);
			if(_n!=null) _p+="/"+$('#_src_label').val(); else _p+="/-";
			$('#_result').show();$("#_rsttitle").text("Search Result");
			_doQ(_usrc, _p, _columns);
		}		
	);
});

var _doQ = function _doQ(_url, _params, _prc){
	 if (_url.replace("^\\s*$","").length > 1 && _url != null) {
		 if(_params!=='') _url+=_params;  else _url+='null/null';
	        $.ajax({
	            type: "GET", url: _url, data: "{}",
	            contentType: "application/json; charset=utf-8", cache: false, dataType: "json",
	            success: function(_d) {
	            	_prc(_d);
	            },error: function() { 
	            }
	        });
	  }
}

var _doPost = function(_url, _j, _prc) {
    $.ajax({
        url: _url, type: "POST", data: JSON.stringify(_j),	//{ apiKey: "23462", method: "example", ip: "208.74.35.5" }
        contentType: "application/json; charset=utf-8",
        success: function (data, textStatus, jQxhr) { _prc(data);
        }, error: function (xhr, ajaxOptions, thrownError) {
        	_on200(xhr.status);
         	console.info(xhr.status);
        }
    });
};

var _columns = function(_d){
	if(_d!=null){
		var _h = "";
		var _b = "";
		for(i in _form.fields){
			if(_form.fields[i]._type!=="HD"){
				_h+="<th>"+_form.fields[i]._label+"</th>"
				_b+="<td></td>";
			}
		}
		_h="<tr>"+_h+"</tr>";
		_b="<tr>"+_b+"</tr>";

        var _t = '<div class="table-responsive"><table class="table table-striped table-sm"><thead>'+_h+'</thead><tbody id="_records">'+_b +'</tbody></table></div>';
             
         $('#_resultcontent').html(_t);
         		          
         var _rc = "";
          for(i in _d.list){
        	  _rc+='<tr>';
        	  _rc+='<td><a href="javascript:void(0)" onclick=_update("'+_d.list[i].cid+'") >'+_d.list[i].name+'</a></td>';
        	  _rc+='<td>'+_d.list[i].label+'</td>';
        	  _rc+='<td>'+_d.list[i].description+'</td>';
        	  _rc+='<td>'+_d.list[i].dataType+'</td>';
        	  _rc+='<td>'+_d.list[i].url+'</td>';
        	  _rc+='<td>'+_d.list[i].regex+'</td>';
        	  _rc+='</tr>';
          }
          
         $('#_records').html(_rc);
	}
}
_loadCard("Search");
_show_search();
_loadResult("Search Result");$('#_result').hide();

</script>
<div id="_content"></div>
<script language="javascript"> $("#_card").width("1300px"); </script>

$(document).ready(function(){loading()})
		
function loading(){
const app = document.getElementById('root');

const container = document.createElement('div');
container.setAttribute('class', 'container');

app.appendChild(container);




var request = new XMLHttpRequest()
request.open('GET', 'http://localhost:8080/api/recipe', true);
request.onload = function() {
  // Begin accessing JSON data here
  var data = JSON.parse(this.response);
  if (request.status >= 200 && request.status < 400) {
    data.forEach(recipe => {
      const card = document.createElement('div');
      card.setAttribute('class', 'card');
      
      
      const img = document.createElement('img');
      img.setAttribute('class','card-img-top');
      img.setAttribute('src','recipeimg/'+recipe.url);
      img.setAttribute('alt',recipe.url);
      
      const h1 = document.createElement('h1');
      h1.textContent = recipe.title;
      
      const timestamp = document.createElement('p');
      timestamp.textContent = recipe.updatedAt;

      const p = document.createElement('p');
      recipe.cookingins = recipe.cookingins.substring(0, 300);
      p.textContent = recipe.cookingins;
    	  
     const leftbutton = document.createElement('button');
     
      leftbutton.setAttribute('id',recipe.id)     ;
      leftbutton.setAttribute('type','button');
      leftbutton.setAttribute('class','btn btn-default');
      leftbutton.setAttribute('href','#updaterecipemodal');
      leftbutton.setAttribute('data-toggle','modal');
      leftbutton.setAttribute('data-target','#updaterecipemodal');
      leftbutton.setAttribute('onclick','editdata(this.id)');
      leftbutton.textContent = "EDIT";
    	  
    	
      
      const rightbutton = document.createElement('button');
      rightbutton.setAttribute('id',recipe.id);
      rightbutton.setAttribute('type','button');
      rightbutton.setAttribute('class','btn btn-default');
      rightbutton.setAttribute('onclick','deleteFunction(this.id)');
      rightbutton.textContent = "DELETE";
    	  
      
      const indicator = document.createElement('img');
      indicator.setAttribute('alt','VEG');
      
      if(recipe.indicator == "veg"){
    	  
          indicator.setAttribute('src','/img/veg.png')     ;     
          indicator.setAttribute('height','50px');
          indicator.setAttribute('width','50px');
          
      }
      if(recipe.indicator == "nonveg"){
    	  
          indicator.setAttribute('src','/img/nonveg.png');
          indicator.setAttribute('height','50px');
          indicator.setAttribute('width','50px');
    	  
      }
      container.appendChild(card);
      card.appendChild(img);
      card.appendChild(h1);
      card.appendChild(p);
      card.appendChild(indicator);
      card.appendChild(leftbutton);
      card.appendChild(rightbutton);
      card.appendChild(timestamp);
      
    })
  }
  else { 
	  const card = document.createElement('div');
      card.setAttribute('class', 'card');
	  const h1 = document.createElement('h1');
	  h1.setAttribute('align','center');
      h1.textContent = "NO DATA FOUND";
    	  container.appendChild(card);
          card.appendChild(h1);
  }
}

request.send();
};


function processFormData(){
	
	var obj={};
	
	obj.title = $('#title').val();
obj.servingsize = $('#servingsize').val();
obj.indicator = $('#indicator').val();
obj.cookingins = $('#cookingins').val();
obj.ingredients = $('#ingredients').val();
obj.url = $('#url').val();
	
	var data = JSON.stringify(obj); 

	$.ajax({
		  type: "POST",
		  url: 'http://localhost:8080/api/recipe',
		  data: data,
		  success: function(){window.location='index.html'},
		  contentType: 'application/json'
		});
	}


function deleteFunction(id){
	
	$.ajax({
		  type: "DELETE",
		  url: 'http://localhost:8080/api/recipe/'+id,
		  success: function() {window.location='index.html'}
		});
	
}

function editFunction(){
	
	var obj={};
	obj.title = $('#updatetitle').val();
obj.servingsize = $('#updateservingsize').val();
obj.indicator = $('#updateindicator').val();
obj.cookingins = $('#updatecookingins').val();
obj.ingredients = $('#updateingredients').val();
obj.url = $('#updateurl').val();
	
	var data = JSON.stringify(obj); 
	
	var id = $('#hdvalue').val();
	$.ajax({
		  type: "PUT",
		  url: 'http://localhost:8080/api/recipe/'+id,
		  data: data,
		  success: function(data){window.location='index.html'},
		  contentType: 'application/json',
		  dataType: "json",
		});
	
}


function editdata(id){
	$('#hdvalue').val(id);
	$.ajax({
		  type: "GET",
		  url: 'http://localhost:8080/api/recipe/'+id,
		  success: function(data){
			  $('#updatetitle').val(data.title);
		      $('#updateservingsize').val(data.servingsize);
		      $('#updateindicator').val(data.indicator);
		      $('#updatecookingins').val(data.cookingins);
		      $('#updateingredients').val(data.ingredients);
		      $('#updateurl').val(data.url);
		      
				  },
		  contentType: 'application/json',
		  dataType: "json",
		});
	
	
}
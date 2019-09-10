
$(document).ready(function(){
const app = document.getElementById('root')

const container = document.createElement('div')
container.setAttribute('class', 'container')

app.appendChild(container)




var request = new XMLHttpRequest()
request.open('GET', 'http://localhost:8080/api/recipe', true)
request.onload = function() {
  // Begin accessing JSON data here
  var data = JSON.parse(this.response)
  if (request.status >= 200 && request.status < 400) {
    data.forEach(recipe => {
      const card = document.createElement('div')
      card.setAttribute('class', 'card')
      
      
      const img = document.createElement('img')
      img.setAttribute('class','card-img-top')
      img.setAttribute('src','recipeimg/'+recipe.url)
      img.setAttribute('alt',recipe.url)
      
      const h1 = document.createElement('h1')
      h1.textContent = recipe.title

      const p = document.createElement('p')
      recipe.cookingins = recipe.cookingins.substring(0, 300)
      p.textContent = `${recipe.cookingins }...`
    	  
     const leftbutton = document.createElement('button')
      leftbutton.setAttribute('id','leftbtn')
      leftbutton.setAttribute('type','button')
      leftbutton.setAttribute('class','btn btn-default')
      leftbutton.textContent = "EDIT"
      
      const rightbutton = document.createElement('button')
      rightbutton.setAttribute('id','rightbtn')
      rightbutton.setAttribute('type','button')
      rightbutton.setAttribute('class','btn btn-default')
      rightbutton.textContent = "DELETE"
    	  

      const input = document.createElement('input')
      input.setAttribute('id','hide')
      input.setAttribute('name','hidden')
      input.setAttribute('type','hidden')
      input.setAttribute('value',recipe.id)
      
      const indicator = document.createElement('img')
      indicator.setAttribute('alt','VEG')
      
      if(recipe.indicator == "veg"){
    	  
          indicator.setAttribute('src','/img/veg.png')          
          indicator.setAttribute('height','50px')
          indicator.setAttribute('width','50px')
          
      }
      if(recipe.indicator == "nonveg"){
    	  
          indicator.setAttribute('src','/img/nonveg.png')
          indicator.setAttribute('height','50px')
          indicator.setAttribute('width','50px')
    	  
      }
      
      
      
      container.appendChild(card)
      card.appendChild(input)
      card.appendChild(img)
      card.appendChild(h1)
      card.appendChild(p)
      card.appendChild(indicator)
      card.appendChild(leftbutton)
      card.appendChild(rightbutton)
    })
  }else {
	  
	  const card = document.createElement('div')
      card.setAttribute('class', 'card')
	  const h1 = document.createElement('h1')
	  h1.setAttribute('align','center')
      h1.textContent = "NO DATA FOUND"
    	  container.appendChild(card)
          card.appendChild(h1)
  }
}

request.send()
});


function processFormData(){
	var x = document.getElementById("formData");
	  var data = JSON.stringify(x.serializeArray() ); //  <-----------

	  console.log( data );
	  return false; //don't submit
	}
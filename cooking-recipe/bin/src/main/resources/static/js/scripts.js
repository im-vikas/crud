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
      
      const h1 = document.createElement('h1')
      h1.textContent = recipe.title

      const p = document.createElement('p')
      recipe.cookingins = recipe.cookingins.substring(0, 300)
      p.textContent = `${recipe.cookingins }...`

      container.appendChild(card)
      card.appendChild(h1)
      card.appendChild(p)
    })
  } else {
    const errorMessage = document.createElement('marquee')
    errorMessage.textContent = `Gah, it's not working!`
    app.appendChild(errorMessage)
  }
}

request.send()
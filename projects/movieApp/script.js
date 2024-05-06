const appSettings = {
    databaseURL: "https://playground-c5b18-default-rtdb.europe-west1.firebasedatabase.app"
}

const inputFieldEl = document.getElementById("input-field")
const addButtonEl = document.getElementById("add-button")

addButtonEl.addEventListener("click", function() {
    let inputValue = inputFieldEl.value
    
    console.log(`${inputValue} added to database`)
})


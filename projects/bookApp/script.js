import { initializeApp } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-app.js"
import { getDatabase, ref, onValue } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-database.js"

const appSettings = {
    databaseURL: "https://best-reads-afeb4-default-rtdb.firebaseio.com/"
}

const app = initializeApp(appSettings)
const database = getDatabase(app)
const booksInDB = ref(database, "books")

onValue(booksInDB, function(snapshot) {
    let booksArray = Object.values(snapshot.val())
    console.log(booksArray)
})

const booksEl = document.getElementById("books")

function clearBooksListEl() {
    booksEl.innerHTML = ""
}

function appendBookToBooksListEl(bookValue) {
    booksEl.innerHTML += `<li>${bookValue}</li>`
}
function showAlert() {
    alert("The book is saved successfully!");
}

function Validator(){
document.getElementById("save-button").addEventListener("click", function(event){
    event.preventDefault();
  });
  showAlert();
}

function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
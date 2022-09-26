const body = document.querySelector("body"),
      sidebar = body.querySelector(".sidebar"),
      toggle = body.querySelector(".toggle"),
      opcion = body.querySelector(".nav-link"),
      userLogin = document.getElementById("user-login"),
      singOut = document.getElementById("sing-out"),
      menuHambur = document.getElementById("menu-hambur"),
      menulink = body.querySelector(".menu-link");



/* Interaccion con modales y botones */

toggle.addEventListener("click", () =>{
    sidebar.classList.toggle("close");
    menulink.classList.toggle("close");
})
userLogin.addEventListener("click", () =>{
    singOut.classList.toggle("pop");
})
menuHambur.addEventListener("click", () =>{
    sidebar.classList.toggle("close");
    menulink.classList.toggle("close");
})


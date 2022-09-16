const body = document.querySelector("body"),
      sidebar = body.querySelector(".sidebar"),
      toggle = body.querySelector(".toggle"),
      opcion = body.querySelector(".nav-link"),
      userLogin = document.getElementById("user-login"),
      singOut = document.getElementById("sing-out"),
      menulink = body.querySelector(".menu-link");


toggle.addEventListener("click", () =>{
    sidebar.classList.toggle("close");
    menulink.classList.toggle("close");
})

/* userLogin.addEventListener("click", () =>{
    singOut.style.visibility = "visible";
    singOut.style.opacity = "1";
}) */

userLogin.addEventListener("click", () =>{
    singOut.classList.toggle("pop");
})

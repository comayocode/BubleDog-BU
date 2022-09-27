const URL_API = "http://localhost:8080/clientes";
let ID_CLIENTE = -1;
let update_flag= false;

/* Funciones para conectar BD */

async function get_clientes(url) {
  // Enviar petición
  const resp = await fetch(url)
  const clientes = await resp.json()
  return clientes
}

function listar_clientes(clientes) {
  // Referenciar tabla
  const table = document.querySelector(".tbody")
  let tbody = ""
  // Iterar clientes
  for (let i = 0; i < clientes.length; i++) {
    const c = clientes[i]
    tbody += `<tr> 
                  <td>${c.nombre}</td>
                  <td>${c.apellidos}</td>
                  <td>${c.telefono}</td>
                  <td>${c.email}</td>
                  <td>${c.nombre_mascota}</td>
                  <td>${c.raza}</td>
                  <td>${c.vacunado}</td>
                  <td>${c.observacion}</td>
                  <td class="button-table">
                  <button class="btn btn-primary" onclick='editar(${JSON.stringify(c)})' data-bs-toggle="modal" data-bs-target="#form"><img src="./IMG/Dashboard/editar.svg" alt="Editar"></button>
                  <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(c)})' data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="./IMG/Dashboard/eliminar.svg" alt="Eliminar"></button>
                  </td>
                </tr>`
  }
  table.innerHTML = tbody
}
function btn_delete(clientes) {
  ID_CLIENTE = clientes.idCliente
  console.log(ID_CLIENTE)
}
/* *******************Funcion Eliminar**************** */

async function delete_user() {
  // enviar petición
  const resp = await fetch(`${URL_API}/${ID_CLIENTE}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  console.log(text)
  main()
}
/* *******************Funcion Capturar datos para Editar**************** */
function editar(e) {
  const fila = e
  document.getElementById("nombre").value = fila.nombre;
  document.getElementById("apellido").value = fila.apellidos;
  document.getElementById("celular").value = fila.telefono;
  document.getElementById("correo").value = fila.email;
  document.getElementById("nombre-mascota").value = fila.nombre_mascota;
  document.getElementById("raza-mascota").value = fila.raza;
  document.getElementById("mascota-vacunada").value = fila.vacunado;
  document.getElementById("observacion").value = fila.observacion;
  document.getElementById("title").innerText="Editar cliente"
  document.getElementById("add").innerText="Editar"
  update_flag= true
  ID_CLIENTE = fila.idCliente
  console.log(ID_CLIENTE)
  console.log(`editar:${update_flag}`)
}
function añadir() {
  document.getElementById("nombre").value = "";
  document.getElementById("apellido").value = "";
  document.getElementById("celular").value = "";
  document.getElementById("correo").value = "";
  document.getElementById("nombre-mascota").value = "";
  document.getElementById("raza-mascota").value = "";
  document.getElementById("mascota-vacunada").value = "";
  document.getElementById("title").innerText="Añadir cliente"
  document.getElementById("add").innerText="Añadir"
  update_flag= false
  console.log(`añadir:${update_flag}`)
}

/* *******************Funcion Editar**************** */

async function update(clientes) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(clientes)
  })

}

/* *******************Funcion añadir**************** */


async function create (clientes) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(clientes)
  })
}

function get_data_form(evt){
  const form = evt.target
  const clientes = {
    cedula: form.cedula.value,
    nombre: form.nombre.value,
    apellidos: form.apellido.value,
    telefono: form.celular.value,
    email: form.correo.value,
    nombre_mascota: form.nombreMascota.value,
    raza: form.razaMascota.value,
    vacunado: form.mascotaVacunada.value,
    observacion: form.observacion.value
  }
  if (update_flag) {
    // añade el id al objeto cliente
    clientes.idCliente = ID_CLIENTE
    update(clientes)
    console.log(`if:${update_flag}`)
  } else {
    create(clientes)
    console.log(`else:${update_flag}`)
  }
}
  /* Traer datos de la BD */

  async function main() {
    const clientes = await get_clientes(URL_API)
    listar_clientes(clientes)
  }
  main()
const URL_API = "http://localhost:8080/servicios";
let ID_SERVICIO = -1;
let update_flag = false;

/* Funciones para conectar BD */

async function get_servicios(url) {
    // Enviar petición
    const resp = await fetch(url)
    const servicios = await resp.json()
    return servicios
}

function listar_servicios(servicios) {
    // Referenciar tabla
    const table = document.querySelector(".tbody")
    let tbody = ""
    // Iterar servicios
    for (let i = 0; i < servicios.length; i++) {
        const s = servicios[i]
        tbody += `<tr> 
                  <td>${s.nombre_servicio}</td>
                  <td>${s.costo_servicio}</td>
                  <td>${s.detalles_servicio}</td>
                  <td class="button-table">
                  <button class="btn btn-primary" onclick='editar(${JSON.stringify(s)})' data-bs-toggle="modal" data-bs-target="#form"><img src="./IMG/Dashboard/editar.svg" alt="Editar"></button>
                  <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(s)})' data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="./IMG/Dashboard/eliminar.svg" alt="Eliminar"></button>
                  </td>
                </tr>`
    }
    table.innerHTML = tbody
}
function btn_delete(servicios) {
    ID_SERVICIO = servicios.id_servicio
    console.log(ID_SERVICIO)
}
/* *******************Funcion Eliminar**************** */

async function delete_user() {
    // enviar petición
    const resp = await fetch(`${URL_API}/${ID_SERVICIO}`, {
        method: 'DELETE'
    })
    const text = await resp.text()
    console.log(text)
    main()
}
/* *******************Funcion Capturar datos para Editar**************** */
function editar(e) {
    const fila = e
    document.getElementById("nombre").value = fila.nombre_servicio;
    document.getElementById("precio").value = fila.costo_servicio;
    document.getElementById("detalles").value = fila.detalles_servicio;
    document.getElementById("title").innerText = "Editar servicio"
    document.getElementById("add").innerText = "Editar"
    update_flag = true
    ID_SERVICIO = fila.id_servicio
    console.log(ID_SERVICIO)
    console.log(`editar:${update_flag}`)
}
function añadir() {
    document.getElementById("nombre").value = "";
    document.getElementById("precio").value = "";
    document.getElementById("detalles").value = "";
    document.getElementById("title").innerText = "Añadir servicio"
    document.getElementById("add").innerText = "Añadir"
    update_flag = false
    console.log(`añadir:${update_flag}`)
}

/* *******************Funcion Editar**************** */

async function update(servicios) {
    // Enviar petición
    const resp = await fetch(URL_API, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(servicios)
    })

}

/* *******************Funcion añadir**************** */


async function create(servicios) {
    // Enviar petición
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(servicios)
    })
}

function get_data_form(evt) {
    const form = evt.target
    const servicios = {
        nombre_servicio: form.nombre.value,
        costo_servicio: form.precio.value,
        detalles_servicio: form.detalles.value
    }
    if (update_flag) {
        // añade el id al objeto servicio
        servicios.id_servicio = ID_SERVICIO
        console.log(form.detalles.value)
        update(servicios)
        console.log(`if:${update_flag}`)
    } else {
        create(servicios)
        console.log(`else:${update_flag}`)
    }
}
/* Traer datos de la BD */

async function main() {
    const servicios = await get_servicios(URL_API)
    listar_servicios(servicios)
}
main()
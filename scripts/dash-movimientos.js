const URL_API = "http://localhost:8080/clientes";
let ID_MOVIMIENTO = -1;
let update_flag = false;

/* Funciones para conectar BD */

async function get_movimientos(url) {
    // Enviar petición
    const resp = await fetch(url)
    const movimientos = await resp.json()
    return movimientos
}

function listar_movimientos(movimientos) {
    // Referenciar tabla
    const table = document.querySelector(".tbody")
    let tbody = ""
    // Iterar movimientos
    for (let i = 0; i < movimientos.length; i++) {
        const m = movimientos[i]
        tbody += `<tr> 
                  <td>${m.cedula}</td>
                  <td>${m.nombre}</td>
                  <td>${m.apellidos}</td>
                  <td>${m.email}</td>
                  <td>${m.email}</td>
                  <td>${m.nombre_mascota}</td>
                  <td>${m.email}</td>
                  <td class="button-table">
                  <button class="btn btn-primary" onclick='editar(${JSON.stringify(m)})' data-bs-toggle="modal" data-bs-target="#form"><img src="./IMG/Dashboard/editar.svg" alt="Editar"></button>
                  <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(m)})' data-bs-toggle="modal" data-bs-target="#exampleModal"><img src="./IMG/Dashboard/eliminar.svg" alt="Eliminar"></button>
                  </td>
                </tr>`
    }
    table.innerHTML = tbody
}
function btn_delete(movimientos) {
    ID_MOVIMIENTO = movimientos.idMovimiento
    console.log(ID_MOVIMIENTO)
}
/* *******************Funcion Eliminar**************** */

async function delete_user() {
    // enviar petición
    const resp = await fetch(`${URL_API}/${ID_MOVIMIENTO}`, {
        method: 'DELETE'
    })
    const text = await resp.text()
    console.log(text)
    main()
}
/* *******************Funcion Capturar datos para Editar**************** */
function editar(e) {
    const fila = e
    document.getElementById("cedula").value = fila.cedula;
    document.getElementById("nombre").value = fila.nombre;
    document.getElementById("apellidos").value = fila.apellidos;
    document.getElementById("servicio").value = fila.email;
    document.getElementById("precio").value = fila.email;
    document.getElementById("nombre-mascota").value = fila.nombre_mascota;
    document.getElementById("fecha-entrega").value = fila.email;
    document.getElementById("title").innerText = "Editar movimiento"
    document.getElementById("add").innerText = "Editar"
    update_flag = true
    ID_MOVIMIENTO = fila.idMovimiento
    console.log(ID_MOVIMIENTO)
    console.log(`editar:${update_flag}`)
}
function añadir() {
    document.getElementById("cedula").value = "";
    document.getElementById("nombre").value = "";
    document.getElementById("apellidos").value = "";
    document.getElementById("servicio").value = "";
    document.getElementById("precio").value = "";
    document.getElementById("nombre-mascota").value = "";
    document.getElementById("fecha-entrega").value = "";
    document.getElementById("title").innerText = "Añadir movimiento"
    document.getElementById("add").innerText = "Añadir"
    update_flag = false
    console.log(`añadir:${update_flag}`)
}

/* *******************Funcion Editar**************** */

async function update(movimientos) {
    // Enviar petición
    const resp = await fetch(URL_API, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(movimientos)
    })

}

/* *******************Funcion añadir**************** */


async function create(movimientos) {
    // Enviar petición
    const resp = await fetch(URL_API, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(movimientos)
    })
}

function get_data_form(evt) {
    const form = evt.target
    const movimientos = {
        nombre: form.nombre.value,
        apellidos: form.apellido.value,
        telefono: form.celular.value,
        email: form.correo.value,
        nombre_mascota: form.nombreMascota.value,
        raza: form.razaMascota.value,
        vacunado: form.mascotaVacunada.value
    }
    if (update_flag) {
        // añade el id al objeto movimiento
        movimientos.idMovimiento = ID_MOVIMIENTO
        update(movimientos)
        console.log(`if:${update_flag}`)
    } else {
        create(movimientos)
        console.log(`else:${update_flag}`)
    }
}
/* Traer datos de la BD */

async function main() {
    const movimientos = await get_movimientos(URL_API)
    listar_movimientos(movimientos)
}
main()
async function registrar_usuarios() {
    const formulario = document.getElementById('registrar');
    let datos = {};
    datos.nombre = document.getElementById('nombre').value;
    datos.email = document.getElementById('email').value;
    datos.telefono = document.getElementById('telefono').value;
    const pass = document.getElementById('pass').value;
    const repass = document.getElementById('repass').value
    if (pass != repass) {
        alert('Las contraseñas no coinciden');
        return;
    }
    datos.pass = pass;
    datos = JSON.stringify(datos);
    console.log(datos);
    const peticion = await fetch('usuarios', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: datos
    });
}

window.addEventListener('click', (e) => {
    //console.log(e.target.id);
    const id = e.target.id;
    if (id == 'registrarse')
        registrar_usuarios();
})
async function login() {
    const formulario = document.getElementById('registrar');
    let datos = {};
    datos.email = document.getElementById('email').value;
    const pass = document.getElementById('pass').value;
    datos.pass = pass;
    datos = JSON.stringify(datos);
    //console.log(datos);
    const peticion = await fetch('usuarios/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: datos
    });
    const respuesta = await peticion.text(); // En este caso text ya que necesitamos guardar en el localStorage el cual solo admite texto.
    if (respuesta != '') {
        localStorage.setItem('token', respuesta);
        localStorage.setItem('email', document.getElementById('email').value);
        window.location.href = 'usuarios.html';
    } else
        console.log('Credenciales no válidas');

}

window.addEventListener('click', (e) => {
    //console.log(e.target.id);
    const id = e.target.id;
    if (id == 'login')
        login();
})
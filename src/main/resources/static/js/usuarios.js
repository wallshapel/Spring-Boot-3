// Llama al plugin de jQuery dataTables
$(document).ready(function() {
    cargar_usuarios();
    $('#usuarios').DataTable();
});

async function cargar_usuarios() {
    const peticion = await fetch('usuarios', {
        method: 'GET',
        headers: headers()
    });
    const usuarios = await peticion.json();
    let usuariosHtml = '';
    for (let usuario of usuarios) {
        usuariosHtml += `
            <tr class="odd">
                <td class="sorting_1">${usuario.nombre}</td>
                <td>${usuario.email}</td>
                <td>${usuario.telefono}</td>
                <td>
                    <a href="#" id="eliminar${usuario.id}" class="btn btn-danger btn-circle btn-sm">
                        <i class="fas fa-trash"></i>
                    </a>
                </td>
            </tr>
        `;
    }
    const tbody = document.querySelector('#usuarios tbody');
    tbody.innerHTML = usuariosHtml;
    //console.log(usuarios);
}

async function eliminar_usuario(id) {
    const peticion = await fetch('usuarios/' + id, {
        method: 'DELETE',
        headers: headers()
    }); 
    location.reload();   
}

function headers() {
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.getItem('token')
    };
}

window.addEventListener('click', (e) => {
    //console.log(e.target.id);
    const id = e.target.id;
    if (id.substring(0, 8) == 'eliminar')
        eliminar_usuario(id.substring(8));
})
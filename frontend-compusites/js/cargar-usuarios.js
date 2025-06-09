document.addEventListener("DOMContentLoaded", () => {
    cargarUsuarios();
});

function cargarUsuarios() {
    fetch("http://localhost:8080/api/usuarios/lista")
        .then(response => {
            if (!response.ok) {
                throw new Error("Error al obtener usuarios");
            }
            return response.json();
        })
        .then(usuarios => {
            const tabla = document.getElementById("tabla-usuarios");
            tabla.innerHTML = ""; // Limpia cualquier fila previa

            usuarios.forEach(usuario => {
                const fila = document.createElement("tr");

                fila.innerHTML = `
                    <td class="text-center">${usuario.id}</td>
                    <td>${usuario.usuario}</td>
                    <td>${usuario.correo}</td>
                    <td class="text-center">${usuario.rol}</td>
                    <td>${usuario.nombres}</td>
                    <td class="text-center">
                        <button class="btn btn-sm btn-danger" onclick="eliminarUsuario(${usuario.id})">
                            ❌
                        </button>
                    </td>
                `;

                tabla.appendChild(fila);
            });
        })
        .catch(error => {
            console.error("Hubo un error al cargar usuarios:", error);
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: 'No se pudieron cargar los usuarios.',
            });
        });
}

function eliminarUsuario(id) {
    Swal.fire({
        title: '¿Estás seguro?',
        text: `¿Deseas eliminar al usuario con ID ${id}?`,
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#d33',
        cancelButtonColor: '#3085d6',
        confirmButtonText: 'Sí, eliminar',
        cancelButtonText: 'Cancelar'
    }).then((result) => {
        if (result.isConfirmed) {
            fetch(`http://localhost:8080/api/usuarios/eliminar/${id}`, {
                method: 'DELETE'
            })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => { throw new Error(text); });
                }
                return response.text();
            })
            .then(mensaje => {
                Swal.fire({
                    icon: 'success',
                    title: 'Eliminado',
                    text: mensaje
                });
                cargarUsuarios(); // Refresca la tabla sin recargar toda la página
            })
            .catch(error => {
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: error.message
                });
            });
        }
    });
}
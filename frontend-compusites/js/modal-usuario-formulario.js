// Mostrar el modal
document.querySelector(".btn.btn-success").addEventListener("click", () => {
    document.getElementById("modal-agregar").classList.remove("d-none");
});

// Ocultar el modal
function cerrarModal() {
    document.getElementById("modal-agregar").classList.add("d-none");
}

// Enviar formulario
document.getElementById("form-agregar-usuario").addEventListener("submit", function (event) {
    event.preventDefault();

    const form = event.target;

    const nuevoUsuario = {
        nombres: form.nombres.value,
        usuario: form.usuario.value,
        correo: form.correo.value,
        contrasenia: form.contrasenia.value,
        rol: form.rol.value
    };

    fetch("http://localhost:8080/api/usuarios/registrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(nuevoUsuario)
    })
    .then(async response => {
        const data = await response.text();

        if (!response.ok) {
            // No cerrar el modal si hay error
            throw new Error(data);
        }

        return data;
    })
    .then(data => {
        // Solo aquí cerramos el modal si fue exitoso
        Swal.fire({
            icon: 'success',
            title: 'Usuario registrado',
            text: data,
            confirmButtonColor: '#198754'
        }).then(() => {
            form.reset(); //limpiar formulario
            cerrarModal(); // //metodo del script "cargar-usuarios.js"
            cargarUsuarios(); //metodo del script "cargar-usuarios.js"
        });
    })
    .catch(error => {
        Swal.fire({
            icon: 'error',
            title: 'Error al registrar',
            text: error.message || "Hubo un problema al registrar el usuario",
            confirmButtonColor: '#dc3545'
        });
    });
});
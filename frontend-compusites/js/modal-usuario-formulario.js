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
    .then(response => {
        if (!response.ok) {
            throw new Error("Error al registrar el usuario");
        }
        return response.json();
    })
    .then(data => {
        cerrarModal();
        Swal.fire({
            icon: 'success',
            title: 'Usuario registrado',
            text: 'El usuario fue registrado correctamente',
            confirmButtonColor: '#198754'
        }).then(() => {
            location.reload();
        });
    })
    .catch(error => {
        console.error("Error:", error);
        Swal.fire({
            icon: 'error',
            title: 'Error',
            text: 'Hubo un problema al registrar el usuario'
        });
    });
});
const usuario = JSON.parse(localStorage.getItem("usuario"));

//Proteger ruta o doc html cuando alguien no logeado quiere acceder a ella y es reedirigido al login
if (!usuario) {
    Swal.fire({
        icon: 'warning',
        title: 'No has iniciado sesión',
        text: 'Por favor inicia sesión para continuar',
        confirmButtonText: 'Ir al login'
    }).then(() => {
        window.location.href = "iniciar-sesion.html";
    });
    // Muy importante: cortar la ejecución aquí
    throw new Error("Usuario no logeado");
} else {
    //EN un caso este logeado y en el local storage se cargan sus datos en pantalla
    document.getElementById("rol").textContent = usuario.rol;
    document.getElementById("usuario").textContent = usuario.usuario;
    document.getElementById("nombres").textContent = usuario.nombres;

    //Alerta simple al lado superor derecho para notificacións sencilla
    Swal.fire({
        toast: true,
        position: 'top-end',
        icon: 'success',
        title: `Sesión iniciada como '${usuario.nombres}'`,
        showConfirmButton: false,
        timer: 3000
    });
}

//Declara esto fuera de cualquier bloque para hacerlo de alcance total, para activar el boton de cerrar sesion.
function cerrarSesion() {
    Swal.fire({
        icon: 'question',
        title: '¿Cerrar sesión?',
        showCancelButton: true,
        confirmButtonText: 'Sí, salir',
        cancelButtonText: 'Cancelar'
    }).then(result => {
        if (result.isConfirmed) {
            localStorage.removeItem("usuario");
            window.location.href = "iniciar-sesion.html";
        }
    });
}
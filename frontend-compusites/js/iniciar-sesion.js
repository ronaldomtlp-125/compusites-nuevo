//Si alguien ya esta logeado, no tengo que logearse de nuevo
const usuario = JSON.parse(localStorage.getItem("usuario"));
if (usuario) {
    window.location.href = "admin-inicio.html";
}

document.getElementById("iniciarSesion-formulario").addEventListener("submit", async function (e) {
    e.preventDefault();

    const usuario = document.getElementById("usuario").value;
    const contrasenia = document.getElementById("contrasenia").value;

    try {
        const response = await fetch("http://localhost:8080/api/usuarios/iniciar-sesion", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ usuario, contrasenia })
        });

        if (response.ok) {
            const data = await response.json();
            //creamos usuario en localstorage con los datos que envia la api "id, nombre y rol"
            localStorage.setItem("usuario", JSON.stringify(data));

            //Alerta flotante con datos que manda la api al centro y reedirige a otra vista html
            Swal.fire({
                icon: 'success',
                title: 'Inicio de sesión exitoso',
                text: `Bienvenido, ${data.usuario}`,
                confirmButtonText: 'Continuar'
            }).then(() => {
                window.location.href = "admin-inicio.html";
            });

        } else {
            //Pantalla de eror generica con datos que envia la api
            const errorText = await response.text();
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: errorText
            });
        }
    } catch (error) {
        console.error("Error al iniciar sesión:", error);
        Swal.fire({
            icon: 'error',
            title: 'Error de red o del servidor',
            text: 'Intenta nuevamente más tarde.'
        });
    }
});





// TODO: añadir lógica particular de esta página

document.getElementById("entrar").onclick = function() {
  peticionApi(`/api/usuario/login`, null, null, document.getElementById("username").value, document.getElementById("password").value)
  .then(respuesta => respuesta.json())
  .then(json => {
        document.getElementById("login").hidden = true;
        document.getElementById("estado").hidden = false;
        if (json.email) {
            document.getElementById('error-msg').classList.remove('error');
            document.getElementById('error-msg').classList.add('hidden');
            document.getElementById("mensaje").textContent = json.email;
            localStorage.setItem('token',JSON.stringify(json));
            muestraPagina('inicio');

        } else if (json.status === 401) {
            document.getElementById('error-msg').classList.remove('hidden');
            document.getElementById('error-msg').classList.add('error');
            document.getElementById("login").hidden = false;
            document.getElementById("estado").hidden = true;
        }
  }).catch(error => {
          document.getElementById("login").hidden = true;
          document.getElementById("estado").hidden = false;
          document.getElementById("accion").value = 'Reintentar';
          document.getElementById("mensaje").textContent = 'Error inesperado';
          console.error(`Error inesperado al hacer login`, error);
  });

};
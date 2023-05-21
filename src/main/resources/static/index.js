// TODO: añadir la lógica común y/o inicial de tu aplicación

function usuarioEstaRegistrado(){
    const token = localStorage.getItem('token');
    if(token) {
        return true;
    } else {
        return false;
    }
}

document.getElementById("accion")

function incrementaCreaContador(contador) {
  peticionApi(`/api/contadores/${contador}/incremento/1`, 'PUT')
    .then(respuesta => respuesta.json())
    .then(json => {
      if (json.status === 404) {
        return peticionApi(`/api/contadores`, 'POST', {nombre: contador, valor: 1});
      } else if (json.status) {
        throw json;
      }
    }).then(respuesta => {
      if (respuesta && respuesta.status !== 201) { throw respuesta; }
    }).catch(error => {
      console.error(`Error inesperado al incrementar contador "${contador}".`, error);
    });
}

document.getElementById("accion").onclick = function() {
    localStorage.removeItem('token');
    document.getElementById("login").hidden = false;
    document.getElementById("estado").hidden = true;
    window.location.href = '#inicio';
};

document.addEventListener("DOMContentLoaded", function() {

    if(localStorage.getItem('token') != null){
        document.getElementById("login").hidden = true;
        document.getElementById("estado").hidden = false;
        document.getElementById("mensaje").textContent = JSON.parse(localStorage.getItem('token')).email;
    }

});

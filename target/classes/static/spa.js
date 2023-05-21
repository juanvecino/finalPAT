// Puedes usar esta función para llamar al API REST de tu aplicación
function peticionApi(ruta, metodo, cuerpo, usuario, clave) {
  usuario = usuario || window.usuario && window.usuario.email;
  clave = clave || window.usuario && window.usuario.clave;
  return fetch(ruta, {
    method: metodo || 'GET',
    headers: {
      'Authorization': 'Basic ' + btoa(usuario + ":" + clave),
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: cuerpo && JSON.stringify(cuerpo) || null
  });
}

// Puedes usar esta función para mostrar una página concreta usando JS, ejemplo: muestraPagina('editor')
function muestraPagina(id) {
  const paginaInicial = window.location.hash || document.querySelector('nav a').getAttribute('href');
  descargaPagina(id || paginaInicial.substring(1), document.querySelector('main'));
}

// Funciones privadas sin uso externo
function descargaPagina(id, padre) {
  fetch(`${id}/index.html`)
    .then(respuesta => {
      if (respuesta.ok) return respuesta.text();
      else throw respuesta;
    }).then(html => {
      padre.innerHTML = `<link rel="stylesheet" href="${id}/index.css">${html}`;
      descargaScript(id, padre);
    }).catch(error => {
      console.warn('No se puede descargar la página', id, error);
      isNaN(id) && descargaPagina(error.status || 500, padre);
    });
}

function descargaScript(id, padre) {
  fetch(`${id}/index.js`)
    .then(respuesta => {
      if (respuesta.ok) return respuesta.text();
      else throw respuesta;
    }).then(js => {
      const script = document.createElement("script");
      script.text = `(function() { ${js} })();`;
      padre.appendChild(script);
    }).catch(error => {
      console.warn('No se puede descargar el script', id, error);
    });
}
window.addEventListener('hashchange', () => muestraPagina());
window.addEventListener('load', () => muestraPagina());
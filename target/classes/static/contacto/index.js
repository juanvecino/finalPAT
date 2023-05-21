incrementaCreaContador('contacto');

document.getElementById("contactar").onclick = function() {

    const postData = {
      nombre: document.getElementById("name").value,
      email: document.getElementById("email").value,
      telefono: document.getElementById("phone").value,
      mensaje : document.getElementById("message").value
    };
    fetch('/api/formulario', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(postData)
    })
    .then(response => response.json())
    .then(data => {
        if(data.status === 400){
            document.getElementById("error").classList.add('hidden');
            document.getElementById("error400").classList.remove('hidden');
            document.getElementById("exito").classList.add('hidden');
        }
        else{
                document.getElementById("exito").classList.remove('hidden');
                document.getElementById("error").classList.add('hidden');
                document.getElementById("error400").classList.add('hidden');
                }
    })
    .catch(error =>
    document.getElementById("error").hidden = false);
  };

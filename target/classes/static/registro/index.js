document.getElementById("registro").onclick = function() {

    const postData = {
      email: document.getElementById("email").value,
      usuario: document.getElementById("username").value,
      credenciales: "Basic "+btoa(document.getElementById("username").value +":" + document.getElementById("password").value),
      rol : "USER",
      domicilio:document.getElementById("domicilio").value
    };
    fetch('/api/usuario', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(postData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.status === 400){
            document.getElementById('error-msg-reg').classList.remove('hidden');
            document.getElementById('error-msg-reg').classList.add('error');
            document.getElementById("login").hidden = false;
            document.getElementById("estado").hidden = true;
            }
        else{
        window.location.href = '#inicio';
        }
    })
    .catch(error => console.error("Error"));
  };

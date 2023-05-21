// TODO: añadir lógica particular de esta página

incrementaCreaContador('perfil');


// AL pulsar comprar añadir a carrito usuario

const boton = document.getElementById("boton");

boton.onclick = function() {
    if(usuarioEstaRegistrado() === true){

        const postData = {
                    idusuario: document.getElementById("mensaje").textContent,
                    idproducto: boton.value,
                    unidades: 1
              };
                fetch("/api/carrito", {
                method: 'POST',
                headers: {'Content-Type': 'application/json'},
                body: JSON.stringify(postData)
                })
        document.getElementById("mensaje-cesta").textContent = "Añadido a la cesta";
    }
      else{
            alert('Por favor, regístrate antes de continuar.');
            muestraPagina("login");
      }
        };

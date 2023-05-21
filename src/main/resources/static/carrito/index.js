// TODO: añadir lógica particular de esta página

incrementaCreaContador('carrito');

// Aquí colocas el código de la función que deseas ejecutar
const userId = document.getElementById("mensaje").textContent;
const apiUrl = `api/carrito/${userId}`;
// Llamada a la API

var removeBtns = document.querySelectorAll(".remove-btn");
if (usuarioEstaRegistrado() === true) {
  fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
      const itemsList = document.querySelector(".cart-items");
      let total_price = 0;
      data.forEach(producto => {
        const id = producto.idproducto;
        fetch("/api/productos/" + id)
          .then(respuesta => respuesta.json())
          .then(item => {
            const itemHtml = `
              <li class="cart-item">
                <img src="${item.url}" alt="${item.nombre}">
                <div class="item-info">
                  <h3>${item.nombre}</h3>
                  <p>${item.descripcion}</p>
                  <div class="item-price">${item.price} €</div>
                  <button class="remove-btn" value="${producto.id}">Eliminar</button>
                </div>
              </li>
            `;
            total_price += parseFloat(item.price);
            itemsList.insertAdjacentHTML("beforeend", itemHtml);
            document.getElementById("total-price").textContent = total_price.toFixed(2) + " €";

            var removeBtns = document.querySelectorAll(".remove-btn");
            removeBtns.forEach(function(btn) {
              btn.onclick = function() {
                var btnValue = this.value;
                   //Delete method
                  // Make an HTTP DELETE request to the server
                  fetch(`/api/carrito/del/${btnValue}`, {
                    method: 'DELETE'
                  })
                  .then(response => {
                    if (response.ok) {
                      // Item deleted successfully
                      console.log('Item deleted');
                      location.reload(true);
                      // Perform any additional actions after deletion
                    } else {
                      // Failed to delete item
                      console.error('Failed to delete item');
                    }
                  })
                  .catch(error => {
                    console.error('Error occurred while deleting item:', error);
                  });
              };
            });
          });
      });
    });
}



const boton = document.getElementById("buy-btn");

boton.onclick = function() {
    if (usuarioEstaRegistrado() === true){
       window.location.href = "#tramite";
    }
    else{
        alert('Por favor, regístrate antes de continuar.');
        muestraPagina("login");
    }

}


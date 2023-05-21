// TODO: añadir lógica particular de esta página


const expiryDateInput = document.getElementById('expiryDate');
const compra = document.getElementById("checkout-btn");
const userId = document.getElementById("mensaje").textContent;
fetch(`/api/${userId}`)
.then(response => response.json())
.then(data => {
        //Change the placeholder text
        document.getElementById("address").value = data.domicilio;
})



expiryDateInput.addEventListener('input', function() {
  let value = expiryDateInput.value;
  value = value.replace(/\D/g, ''); // Eliminar todos los caracteres que no sean dígitos
  value = value.slice(0, 4); // Obtener solo los primeros 4 dígitos

  if (value.length > 2) {
    // Insertar la barra ("/") después de los primeros dos dígitos
    value = value.slice(0, 2) + '/' + value.slice(2);
  }

  expiryDateInput.value = value;
});





compra.onclick = function() {
    const id_usuario = document.getElementById("mensaje").textContent;
    fetch(`/operacion/${id_usuario}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
    })
      .then(response => {
        if (response.ok) {
          alert('Operación realizada con éxito');
          window.location.href = '#inicio';
        } else {
          throw new Error('Error al insertar la operación');
        }
      })
      .catch(error => {
        console.error('Error:', error);
      });
}
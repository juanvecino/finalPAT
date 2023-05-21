// TODO: añadir lógica particular de esta página
incrementaCreaContador('inicio');

// Añado la tabla de productos
const tabla = document.getElementById("ListadoProductos");

const carrusel = document.getElementById("carrusel");
  const imagenes = [ "https://m.media-amazon.com/images/I/61xWPVsXPGL._SX3000_.jpg","https://m.media-amazon.com/images/I/71u9+c6iNiL._SX3000_.jpg"];
  let indice = 0;

setInterval(() => {
  // Actualizar índice
  indice = (indice + 1) % imagenes.length;

  // Cambiar src de la imagen
  const elemento = document.getElementById('AnuncioActual');
  if (elemento !== null) {
    elemento.setAttribute("src", imagenes[indice]);
  }

}, 10000);


fetch("/api/productos")
    .then(respuesta => respuesta.json())
    .then(productos => {
        productos.forEach(producto => {
                    // Crear elementos HTML para el producto
                    const article = document.createElement("article");
                    const figure = document.createElement("figure");
                    const img = document.createElement("img");
                    const figcaption = document.createElement("figcaption");
                    const h3 = document.createElement("h3");
                    const spanPrecio = document.createElement("span");
                    const spanValoracion = document.createElement("span");

                    // Establecer atributos y texto para los elementos
                    article.onclick = function() {
                      window.location.href = '#producto';
                      muestraPagina("producto");
                      setTimeout(() => {
                      fetch("/api/productos/" + producto.id)
                            .then(respuesta => respuesta.json())
                            .then(producto => {
                                const nombre = document.getElementById("nombre");
                                const precio = document.getElementById("precio");
                                const valoracion = document.getElementById("valoracion");
                                const descripcion = document.getElementById("descripcion");
                                const imagen = document.getElementById("imagen");
                                const boton = document.getElementById("boton");
                                nombre.textContent = producto.nombre;
                                precio.textContent = producto.price + "€";
                                valoracion.textContent = producto.valoracion;
                                descripcion.textContent = producto.descripcion;
                                imagen.src = producto.url;
                                imagen.alt = "Imagen del producto";
                                boton.value = producto.id;
                            });
                    }, 100);}

                    img.src = producto.url;
                    img.alt = "Imagen del producto";
                    h3.textContent = producto.nombre;
                    spanPrecio.textContent = producto.price + "€";
                    spanPrecio.classList.add("Precio");
                    spanValoracion.textContent = producto.valoracion + " estrellas";
                    spanValoracion.classList.add("Valoracion");

                    // Agregar elementos al artículo y el artículo a la tabla
                    figure.appendChild(img);
                    figcaption.appendChild(h3);
                    figcaption.appendChild(spanPrecio);
                    figcaption.appendChild(spanValoracion);
                    article.appendChild(figure);
                    article.appendChild(figcaption);
                    tabla.appendChild(article);
        });

});



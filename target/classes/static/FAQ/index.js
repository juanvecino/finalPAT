incrementaCreaContador('faq');
const yesButton = document.querySelector('.yes-button');
  const noButton = document.querySelector('.no-button');
  const contactLink = document.querySelector('.contact-link');

  yesButton.addEventListener('click', () => {
    alert('Nos alegra saber que te ha sido útil esta sección de preguntas frecuentes. ¡Gracias por utilizar nuestra aplicación web!');
  });

  noButton.addEventListener('click', () => {
    contactLink.classList.remove('hidden');
  });

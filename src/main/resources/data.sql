-- Base de datos Usuario
INSERT INTO usuario (usuario,email, credenciales, rol,domicilio) VALUES ('admin1','admin@e.m', 'Basic YWRtaW5AZS5tOmFkbWlu', 'ADMIN','Calle 1 del Admin');
INSERT INTO usuario (usuario,email, credenciales, rol,domicilio) VALUES ('admin1','boss@e.m', 'Basic Ym9zc0BlLm06Ym9z', 'USER','Calle 1 del Boss');
INSERT INTO usuario (usuario,email, credenciales, rol,domicilio) VALUES ('admin1','user@e.m', 'Basic dXNlckBlLm06dXNlcg==', 'USER','Calle 1 del User');

-- Base de datos Productos
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion,price) VALUES ('1', 'Bicicleta R-EX', 'Bicicleta de montñana para ir con tu padre los findes', 'https://m.media-amazon.com/images/I/716aHjNXlJL._AC_UF894,1000_QL80_.jpg', '4', '99.99');
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion, price)
VALUES ('2',
'Cecotec Freidora sin Aceite de 5,5 L de Aire Caliente',
'Cecotec Freidora sin Aceite de 5,5 L de Aire Caliente Cecofry Full InoxBlack 5500 Pro. 1700 W, Dietética y Digital, Panel Táctil, Acabados en Acero Inox, Tecnología PerfectCook, Termostato, 8 Modos',
'https://images-eu.ssl-images-amazon.com/images/I/519AN1zQmbL._AC_UL900_SR900,600_.jpg',
'4.5',
'79.90');
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion, price)
VALUES ('3',
'Air Wick Eléctrico Recambio de Ambientador Eléctrico',
'Air Wick Eléctrico Recambio de Ambientador Eléctrico, Esencia para Casa con Aroma a Flor - 3 unidades',
'https://images-eu.ssl-images-amazon.com/images/I/81lnRu2scbL._AC_UL900_SR900,600_.jpg',
'4.5',
'12.55');
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion, price)
VALUES ('4',
'Russell Hobbs Plancha de Ropa Power Steam Ultra',
'Russell Hobbs Plancha de Ropa Power Steam Ultra - 3100W, Suela Cerámica, Planchado Seco, Golpe Vapor 210g, Antical, Antigoteo, Función Autolimpieza, Apagado Automático, Negro - 20630-56',
'https://images-eu.ssl-images-amazon.com/images/I/81cQBjN5dIL._AC_UL900_SR900,600_.jpg',
'4.3',
'39.20');
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion, price)
VALUES ('5',
'Todocama - Protector de colchón/Cubre colchón Ajustable',
'Todocama - Protector de colchón/Cubre colchón Ajustable, de Rizo, Impermeable y Transpirable. (Todas Las Medidas Disponibles). (Cama 150 x 190/200 cm)',
'https://images-eu.ssl-images-amazon.com/images/I/61+S5QPFOnL._AC_UL900_SR900,600_.jpg',
'4.4',
'16.99');
INSERT INTO Producto (id_product, nombre, descripcion, url, valoracion, price)
VALUES ('6',
'Tefal Daily Cook',
'Tefal Daily Cook - duradero y seguro, Thermo-Signal, mango ergonómico antiquemaduras, apta para todo tipo de cocinas, sin PFOA, plomo ni cadmio, Sartén baja de 26 cm con revestimiento resistente,',
'https://images-eu.ssl-images-amazon.com/images/I/71GBRnNw+OL._AC_UL900_SR900,600_.jpg',
'4.5',
'39.99');







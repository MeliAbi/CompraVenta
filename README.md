# CompraVenta

## Una importante empresa de compraventa de artículos de estilo, “San Nicolás”, ha decidido crear un sistema para permitir la manejar todas las transacciones de esta. Éste contará con la información de los artículos que posee para la venta. Están interesados en contar inicialmente con un módulo que les permita sugerir artículos a los compradores y también llevar un registro de las compras a partir de la información de preferencias disponibles en el perfil de los compradores.

Se pide implementar la lógica para sugerir artículos y registro de compras siguiendo las 
siguientes especificaciones:
- Cada artículo cuenta con un nombre, valor, descripción, cantidad y tipo de 
artículo (de lujo, antigüedad, invaluables y exóticos).
- Por cada cliente el sistema conoce su nombre, presupuesto y el tipo de artículo 
preferido.
- En la generación de sugerencias se tendrá en cuenta la existencia de combos 
vigentes. Cada combo incluye uno o varios artículos y beneficia al cliente con un 
descuento del costo total. Actualmente se manejan los siguientes combos:
 -- Combos porcentuales (X % de descuento en el costo total)
 -- Combos absolutos ($ X por toda la promoción)
 -- Combos A x B (si el cliente compra A, B, C entonces tiene gratis D).

## Sistema.
**1.** El sistema obtiene los siguientes datos de una Base de Datos (no se requiere la carga de datos):
  a. Clientes con sus preferencias.
  b. Artículos con sus características.
  c. Combos para ofrecer.
**2.** Para un usuario que desea interactuar con la aplicación, permitirá:
  a. Sugerir un Artículo que coincida con sus preferencias y créditos disponibles.
    i. No deberá ofrecerse un artículo o combo para el cual no haya stock disponible.
    ii. Deberá priorizarse la oferta de combos y los artículos, respetando ese orden.
    iii. No deberá sugerir un artículo o promoción que no pueda pagar.
    iv. Tampoco deberá ofertarse un artículo que ya haya sido incluida en una promoción anteriormente comprada por el mismo usuario.
    v. Una vez agotadas las ofertas que coincidan con sus intereses, se ofertarán aquellas que no coincidan, bajo el mismo criterio.
  b. Si el usuario acepta, se guardará dentro de sus compras. Un producto o combo aceptada no podrá cancelarse.
  c. En todo momento, el cliente podrá ver sus compras y créditos disponibles,  que habrán contabilizado los gastados.
**3.** Todo uso indebido de los componentes deberá lanzar una excepción, pero se solicita que al menos un intento de compra de artículo / combo con crédito insuficiente lance una excepción (CreditosInsuficientesException).
4. La resolución debe incluir pruebas unitarias de las funcionalidades de combo,compras, la sugerencia artículos / combos y que se lance una excepción

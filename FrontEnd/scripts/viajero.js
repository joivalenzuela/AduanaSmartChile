
function mostrarFormulario() {
    document.getElementById('formulario').style.display = 'block';
}

function agregarProducto() {
    const productosDiv = document.getElementById('productos');
    const nuevoProducto = document.createElement('div');
    nuevoProducto.className = 'producto';
    nuevoProducto.innerHTML = `
        <label>Producto a declarar:</label>
        <input type="text" name="producto[]" required>
        <label>Cantidad:</label>
        <input type="number" name="cantidad[]" min="1" required>
        <label>Descripción:</label>
        <textarea name="descripcion[]" rows="2"></textarea>
        <button type="button" onclick="eliminarProducto(this)">Eliminar</button>
        <hr>
    `;
    productosDiv.appendChild(nuevoProducto);
}

function eliminarProducto(boton) {
    const productoDiv = boton.parentElement;
    productoDiv.remove();
}
  
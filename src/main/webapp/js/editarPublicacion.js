

let titulo = document.getElementById("titulo").value;
let autor = document.getElementById("autor").value;
let id = document.getElementById("id").value;
let descripcion = document.getElementById("descripcion").value;
let fecha = document.getElementById("fecha").value; 
let estado = document.getElementById("estado").value; 

let url = 'http://localhost.webComic/EditarComic';
let params = `?id=${id}&titulo=${titulo}&autor=${autor}&descripcion=${descripcion}&fecha=${fecha}&estado=${estado}`; 

async function editarCliente(){
   await fetch(url + params , {
        method : 'GET'
    }
            )
        
  return console.log("comic editado")
}

document.getElementById("submit").addEventListener('click', editarCliente); 
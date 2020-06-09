const base = 'http://localhost:8080/webcomics'
function mostrarPublicaciones(){
    getComic().then(
            json => {
                generarTabla(json.data);
                    }
           );
}
async function getComic(){
    
    let url = base  + '/getComics';
    let response = await fetch(url); 
    let json = await response.json(); 
    return json; 
}

function generarTabla(data){
    let container = document.getElementById("cajaPubli");
    let contenidoHTML = ``;
    
    for(unComic of data){
        
        contenidoHTML += `
      
                <div class="col-md-4 post container">
                                           <div class="caja">
                                               <a href="UnComic?idComic=${unComic.comicId}" class="thumbnail"> <img class="img-thumbnail miniatura" src=" ${unComic.comicFoto} " alt=""></a>
                                               
                                                   
                                                   <div class="caption">
                                           
                                                   <h2><a href="UnComic?idComic=${unComic.comicId}" class="post-titulo"> ${unComic.comicTitulo} </a></h2>
                                                   <span ><a href="" dissabled class="text-right"> ${unComic.comicCategoria.catNombre}</a></span>
                                                   <br>
                                                   <span class="post-fecha">${unComic.comicFecha} </span> por <span class="post-autor"><a href="#"> ${unComic.comicAutor} </a></span>
                                                   <p class="post-reseña"> ${unComic.comicDescripcion}
                                                           </p>
                                                   
                                                    </div> 
                                                   
                                               </div> 
                                               </div>
                                                           
           `
        
    }
    
    container.innerHTML = contenidoHTML;
    
}

mostrarPublicaciones(); 


let buscador = document.getElementById("buscador");
buscador.addEventListener('keyup' , buscarCliente);

function buscarCliente(){
   let url = base  + '/getComics';
   let terminoBuscado = buscador.value;
   let params = `?search=${terminoBuscado}`;
    fetch(url + params).then(
            response => response.json()
            ).then(
            resultado => {
                generarTabla(resultado.data)
            }); 
    
}

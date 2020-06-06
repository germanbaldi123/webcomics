const base = 'http://localhost:8080/webcomics'
function mostrarPublicaciones(){
    getComic().then(
            json => {
                generarTabla(json.data);
                    }
           );
}
async function getComic(){
    
    let url = base  + '/getPublicaciones';
    //let params = '?method=publicUser'; 
    let response = await fetch(url); 
    let json = await response.json(); 
    return json; 
}

function eliminarComic(e){

                 

                    fetch( `Panel?funcion=eliminar&idComic=${e.currentTarget.value}`, {
                                                            method: 'POST' ,

                                                              credentials: 'include'
                                                    } );

                                              alert("publicacion eliminada exitosamente"); 
                                  mostrarPublicaciones(); 

                }

function generarTabla(data){
    let container = document.getElementById("contenedor");
    let contenidoHTML = `<div class="col-md-4 post container">
                <div class="caja">
                   
                   <a href="nuevoComic"> <h5 id="mas" class="text-center">+</h5>
                    <h3 id="nuevaPublicacion" class="text-center">Nueva Publicacion</h3></a>
                </div>
                
 
            </div>`;
    
    for(unComic of data){
        
        contenidoHTML += `
<div class="col-md-4 post container">
               <div class="caja">
                   <a href="#" class="thumbnail"> <img class="img-thumbnail miniatura" src=" ${unComic.comicFoto} " alt=""></a>
                  <div class="caption">
 
                  <h2><a href="#" class="post-titulo">${unComic.comicTitulo}</a></h2>
                  <span class="post-fecha">${unComic.comicFecha}</span> por <span class="post-autor"><a href="#">${unComic.comicAutor}</a></span>
                  <p class="post-reseña"> ${unComic.comicDescripcion}</p>
                  <div class="contenedor-de-botones row container">
                     <a href="EditarComic?idComic=${unComic.comicId}"><button class="btn col btn-success editarComic"  value="${unComic.comicID}"> Editar </button></a>

                      <div class="col">
                          <button class="btn btn-danger col eliminarComic" value="${unComic.comicId}">Eliminar</button>
                       </div>

                  
                    
                     
                     
 
                  
 
                   </div>   
               </div>
            
             </div>
 
         </div>`
        
    }
    
    container.innerHTML = contenidoHTML;
    $('.eliminarComic').click(eliminarComic);
    
}

mostrarPublicaciones(); 




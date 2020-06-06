const base = 'http://localhost:8080/webcomics';

//conseguir listas
async function getListaFav(){
    
    let url = base  + '/getListas';
    let params = '?method=listaFav';
    let response = await fetch(url + params); 
    let json = await response.json(); 
    return json; 
}

async function getListaLeidos(){
    
    let url = base  + '/getListas';
    let params = '?method=listaLeidos';
    let response = await fetch(url + params); 
    let json = await response.json(); 
    return json; 
}

async function getListaPendientes(){
    
    let url = base  + '/getListas';
    
    let response = await fetch(url); 
    let json = await response.json(); 
    return json; 
}

//funciones eliminar

function eliminarLeido(e){

                fetch(`EliminarLista?lista=leidos&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                                                                        mostrarListaLeidos(); 
                }
                
 function eliminarFav(e){

                fetch(`EliminarLista?lista=favoritos&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                                                                        mostrarListaFav(); 
                }
                
function eliminarPendiente(e){

                fetch(`EliminarLista?lista=pendientes&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                                                                        mostrarListaPendientes(); 
                }
                
//generar listas

function generarListaFav(data){
    let container = document.getElementById("lista-favoritos");
    let contenidoHTML = "";
    
    for(unComic of data){
        contenidoHTML += ` 
<tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" ${unComic.comicFoto}  " alt=""> <a href="UnComic?idComic=${unComic.comicId}"> ${unComic.comicTitulo} </a>
                        <button type="button" class="close eliminarFav" value="${unComic.comicId}" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>`
    }; 
    container.innerHTML = contenidoHTML; 
    $('.eliminarFav').click(eliminarFav);
}

function generarListaLeidos(data){
    let container = document.getElementById("lista-leidos");
    let contenidoHTML = "";
    
    for(unComic of data){
        contenidoHTML += ` 
<tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" ${unComic.comicFoto}  " alt=""> <a href="UnComic?idComic=${unComic.comicId}"> ${unComic.comicTitulo} </a>
                        <button type="button" class="close eliminarLeido" value="${unComic.comicId}" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>`
    };
    container.innerHTML = contenidoHTML; 
    $('.eliminarLeido').click(eliminarLeido);
}

function generarListaPendientes(data){
    let container = document.getElementById("lista-pendientes");
    let contenidoHTML = "";
    
    for(unComic of data){
        contenidoHTML += ` 
<tr>
                    <td><img class="img-thumbnail icono-lista-comic" src=" ${unComic.comicFoto}" alt=""> <a href="UnComic?idComic=${unComic.comicId}"> ${unComic.comicTitulo} </a>
                        <button type="button" class="close eliminarPendiente" value="${unComic.comicId}" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                        </button></td>
                </tr>`
    }; 
    container.innerHTML = contenidoHTML; 
    $('.eliminarPendiente').click(eliminarPendiente);
}


function mostrarListaFav(){
    getListaFav().then(
            json => {
                generarListaFav(json.data);
    }
            );
}

function mostrarListaLeidos(){
    getListaLeidos().then(
            json => {
                generarListaLeidos(json.data);
    }
            );
   
}

function mostrarListaPendientes(){
   
    
    getListaPendientes().then(
            json => {
                generarListaPendientes(json.data);
    }
            );
}

mostrarListaFav();
mostrarListaLeidos();
mostrarListaPendientes(); 
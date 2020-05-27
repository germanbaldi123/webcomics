var btnPendientes = document.getElementById("btnPendientes");
var btnFav = document.getElementById("btnFav");
var btnLeidos = document.getElementById("btnLeidos");


btnPendientes.addEventListener('click', agregarPendientes);
btnFav.addEventListener('click', agregarFav);
btnLeidos.addEventListener('click', agregarLeidos);

function agregarPendientes(){
    let params = (new URL(document.location)).searchParams;
    
    let idComic = params.get("idComic");
    
    fetch( `Listas?lista=pendientes&idComic=${idComic}`, {
                                                method: 'POST' ,
                                            
                                                credentials: 'include'
                                            } );
}

function agregarFav(){
    let params = (new URL(document.location)).searchParams;
    
    let idComic = params.get("idComic");
    
    fetch( `Listas?lista=favoritos&idComic=${idComic}`, {
                                                method: 'POST' ,
                                            
                                                credentials: 'include'
                                            } );
}

function agregarLeidos(){
    let params = (new URL(document.location)).searchParams;
    
    let idComic = params.get("idComic");
    
    fetch( `Listas?lista=leidos&idComic=${idComic}`, {
                                                method: 'POST' ,
                                            
                                                credentials: 'include'
                                            } );
}

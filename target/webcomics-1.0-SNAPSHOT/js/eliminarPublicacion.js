                var btnEliminar = document.getElementsByClassName("eliminarComic");
                for(btn of btnEliminar){
                        btn.addEventListener('click', eliminarComic);
                }


                function eliminarComic(e){

                  //alert(ele.currentTarget.value); 

                    fetch( `Panel?funcion=eliminar&idComic=${e.currentTarget.value}`, {
                                                            method: 'POST' ,

                                                              credentials: 'include'
                                                    } );

                                              alert("publicacion eliminada exitosamente")


                }
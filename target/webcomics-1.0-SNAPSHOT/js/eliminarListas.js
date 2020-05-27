                var btnEliminarLeido = document.getElementsByClassName("eliminarLeido");
                for(btn of btnEliminarLeido){
                        btn.addEventListener('click', eliminarLeido);
                };


                function eliminarLeido(e){

                fetch(`EliminarLista?lista=leidos&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                }
                
                
                var btnEliminarFav = document.getElementsByClassName("eliminarFav");
                for(btn of btnEliminarFav){
                        btn.addEventListener('click', eliminarFav);
                };


                function eliminarFav(e){

                fetch(`EliminarLista?lista=favoritos&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                }
                
                
                var btnEliminarPendiente = document.getElementsByClassName("eliminarPendiente");
                for(btn of btnEliminarPendiente){
                        btn.addEventListener('click', eliminarPendiente);
                };


                function eliminarPendiente(e){

                fetch(`EliminarLista?lista=pendientes&idComic=${e.currentTarget.value}` , {
                    
                                                                            method : 'POST',
                                                                            
                                                                            credentials: 'include'
                                                                        } );
                }



                
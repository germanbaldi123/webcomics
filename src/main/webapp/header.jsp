
                
                <%@page import="com.mycompany.webcomics.model.entities.User"%>

                    <div class="container-block">
                      <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
                                <a href="index.html" class="navbar-brand">La Guarida</a>
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#menu" aria-controls="menu">
                                        <span class="navbar-toggler-icon"></span>
                                </button>


                                <div class="navbar-collapse collapse" id="menu">

                                        <form class="form-inline my-8 col-lg-10">
                                            <input class="form-control col-sm-6" type="search" id="buscador" placeholder="Search" aria-label="Search">
                                            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
                                        </form>
                                        <ul class="navbar-nav mr-auto my-2 my-lg-0">
                                                <li class="navbar-item dropdown mr-sm-2">
                                                    <a href="comic" class="nav-link dropdown-toggle" id="biblioteca" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Biblioteca</a>

                                                    <div class="dropdown-menu" aria-labelledby="#biblioteca">
                                                        <a href="biblioteca?idCat=1" class="dropdown-item">Accion </a>
                                                        <a href="biblioteca?idCat=3" class="dropdown-item">Romance</a>
                                                        <a href="biblioteca?idCat=4" class="dropdown-item">Terror/Misterio</a>
                                                        <a href="biblioteca?idCat=5" class="dropdown-item">Deporte</a>
                                                        <a href="biblioteca?idCat=6" class="dropdown-item">Infantil</a>
                                                        <a href="biblioteca?idCat=2" class="dropdown-item">Comedia</a>
                                                    </div>
                                                </li>
                                                <li class="navbar-item dropdown mr-sm-2">
                                                        <a href="#" class="nav-link dropdown-toggle" id="miCuenta" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Mi cuenta</a>
                                                        <div class="dropdown-menu" aria-labelledby="#miCuenta">
                                                            <a href="Perfil" class="dropdown-item">Mi perfil </a>
                                                            <a href="Listas" class="dropdown-item">Mis Listas</a>
                                                            <a href="Publicaciones" class="dropdown-item">Publicaciones</a>
                                                            <a href="Logout" class="dropdown-item">Salir</a>
                                                        </div>
                                                 </li>




                                        </ul>



                                </div>



                        </nav>
                    </div>
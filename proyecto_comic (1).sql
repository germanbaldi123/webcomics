-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2020 a las 02:07:14
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_comic`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `cat_id` int(11) NOT NULL,
  `cat_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`cat_id`, `cat_nombre`) VALUES
(1, 'Accion'),
(2, 'Comedia'),
(3, 'Romance'),
(4, 'terror/misterio '),
(5, 'Deportes'),
(6, 'Infantil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comic`
--

CREATE TABLE `comic` (
  `com_id` int(11) NOT NULL,
  `com_titulo` varchar(100) NOT NULL,
  `com_cat_id` int(11) NOT NULL,
  `com_est_id` int(11) NOT NULL,
  `com_user_id` int(11) NOT NULL,
  `com_descripcion` varchar(1000) NOT NULL,
  `com_tapa` varchar(1000) NOT NULL,
  `fecha` varchar(4) NOT NULL,
  `com_id_autor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comic`
--

INSERT INTO `comic` (`com_id`, `com_titulo`, `com_cat_id`, `com_est_id`, `com_user_id`, `com_descripcion`, `com_tapa`, `fecha`, `com_id_autor`) VALUES
(78, 'holi', 1, 1, 1, 'sadasdasdasd', 'https://images-na.ssl-images-amazon.com/images/I/91yiBtD0imL.jpg', '1995', 'autor'),
(82, 'este', 4, 2, 6, 'sdfsdf', 'https://hablandodecomics.files.wordpress.com/2012/01/portada-93-hulk.jpg?w=584', '2020', 'autor 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `est_id` int(11) NOT NULL,
  `est_nombre` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`est_id`, `est_nombre`) VALUES
(1, '\"en curso\"'),
(2, '\"finalizado\"');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_fav`
--

CREATE TABLE `lista_fav` (
  `user_id_fav` int(11) NOT NULL,
  `comic_id_fav` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lista_fav`
--

INSERT INTO `lista_fav` (`user_id_fav`, `comic_id_fav`) VALUES
(6, 78);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_leidos`
--

CREATE TABLE `lista_leidos` (
  `com_leido_id` int(11) NOT NULL,
  `user_leido_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_pendientes`
--

CREATE TABLE `lista_pendientes` (
  `com_pendiente_id` int(11) NOT NULL,
  `user_pendiente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `lista_pendientes`
--

INSERT INTO `lista_pendientes` (`com_pendiente_id`, `user_pendiente_id`) VALUES
(78, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `username` varchar(25) NOT NULL,
  `user_nombre` varchar(25) NOT NULL,
  `user_apellido` varchar(25) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_pass` varchar(20) NOT NULL,
  `user_foto` varchar(100) NOT NULL,
  `user_desc` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`user_id`, `username`, `user_nombre`, `user_apellido`, `user_email`, `user_pass`, `user_foto`, `user_desc`) VALUES
(1, 'Geercho', 'German', 'Baldi', 'germannahuelbaldi@gmail.com', '44444444', 'tumama.jpg', 'lorem'),
(2, 'alberfernandezok', 'alberto', 'fernandez', 'alberto@hotmail.com', '44444444', 'https://www.filo.news/__export/1584614557427/sites/claro/img/2020/03/19/alberto_1.jpg_1359985867.jpg', 'actual presidente XDDD'),
(3, 'userPrueba', 'danie', 'gomez', 'lalalaalal@gmail.com', '44444', 'https://ultrabrit.com/wp-content/uploads/2017/08/john-lennon-01.jpg', 'sigo vivo'),
(4, 'Prueba', 'Prueba', ' de prueba', 'prueba@prueba.com', '12345678', 'foto.jsp', 'prueba'),
(5, 'sdfs', '', '', '', '', 'foto.jsp', ''),
(6, 'germaaan', 'german', 'baldi', 'germanbaldi@gmail.com', '123456', 'foto.jsp', 'Soy un kpo'),
(7, 'germancito', 'German', 'Baldi', 'germannahuelbaldi@gmail.com', '123456', 'foto.jsp', 'Mi nombre es german'),
(8, 'nahuel_95', 'nahuel', 'mariÃ±o', 'nahuelmarino@gmail.com', '123456', 'foto.jsp', 'nahuel'),
(9, 'wilchen', 'ivan', 'wilchen', 'wilche@wilche.com', '123456', 'foto.jsp', 'soy puto xD'),
(11, 'tomibaldi', 'tomi', 'baldi', 'tomibaldi@gmail.com', 'tomibaldi', 'foto.jsp', 'tu mama'),
(12, 'alejandro', 'alejandro', 'alejandreo', 'alejandro@gmail.com', '123456', 'foto.jsp', 'asdasd');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`cat_id`);

--
-- Indices de la tabla `comic`
--
ALTER TABLE `comic`
  ADD PRIMARY KEY (`com_id`),
  ADD KEY `com_cat_id` (`com_cat_id`),
  ADD KEY `com_est_id` (`com_est_id`),
  ADD KEY `com_user_id` (`com_user_id`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`est_id`);

--
-- Indices de la tabla `lista_fav`
--
ALTER TABLE `lista_fav`
  ADD PRIMARY KEY (`user_id_fav`,`comic_id_fav`),
  ADD KEY `lista_fav_ibfk_1` (`comic_id_fav`);

--
-- Indices de la tabla `lista_leidos`
--
ALTER TABLE `lista_leidos`
  ADD PRIMARY KEY (`com_leido_id`,`user_leido_id`),
  ADD KEY `lista_leidos_ibfk_1` (`user_leido_id`);

--
-- Indices de la tabla `lista_pendientes`
--
ALTER TABLE `lista_pendientes`
  ADD PRIMARY KEY (`com_pendiente_id`,`user_pendiente_id`),
  ADD KEY `lista_pendientes_ibfk_1` (`user_pendiente_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `cat_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `comic`
--
ALTER TABLE `comic`
  MODIFY `com_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `est_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comic`
--
ALTER TABLE `comic`
  ADD CONSTRAINT `comic_ibfk_1` FOREIGN KEY (`com_cat_id`) REFERENCES `categorias` (`cat_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `comic_ibfk_2` FOREIGN KEY (`com_est_id`) REFERENCES `estados` (`est_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `comic_ibfk_4` FOREIGN KEY (`com_user_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `lista_fav`
--
ALTER TABLE `lista_fav`
  ADD CONSTRAINT `lista_fav_ibfk_1` FOREIGN KEY (`comic_id_fav`) REFERENCES `comic` (`com_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_fav_ibfk_2` FOREIGN KEY (`user_id_fav`) REFERENCES `users` (`user_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `lista_leidos`
--
ALTER TABLE `lista_leidos`
  ADD CONSTRAINT `lista_leidos_ibfk_1` FOREIGN KEY (`user_leido_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_leidos_ibfk_2` FOREIGN KEY (`com_leido_id`) REFERENCES `comic` (`com_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `lista_pendientes`
--
ALTER TABLE `lista_pendientes`
  ADD CONSTRAINT `lista_pendientes_ibfk_1` FOREIGN KEY (`user_pendiente_id`) REFERENCES `users` (`user_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `lista_pendientes_ibfk_2` FOREIGN KEY (`com_pendiente_id`) REFERENCES `comic` (`com_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 31-10-2024 a las 22:06:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `nutricionista`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `cod_comida` int(11) NOT NULL,
  `nombre_comida` varchar(255) NOT NULL,
  `calorias_por_porcion` decimal(5,2) NOT NULL,
  `tipo_comida` varchar(255) NOT NULL,
  `detalle` varchar(300) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida_tiene_ingredientes`
--

CREATE TABLE `comida_tiene_ingredientes` (
  `id_comida` int(11) NOT NULL,
  `id_ingrediente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `id_dieta` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `peso_inicial` decimal(5,2) NOT NULL,
  `peso_final` decimal(5,2) DEFAULT NULL,
  `total_calorias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta_tiene_menu`
--

CREATE TABLE `dieta_tiene_menu` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_dieta` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingredientes`
--

CREATE TABLE `ingredientes` (
  `id_ingrediente` int(11) NOT NULL,
  `nombre_ingrediente` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu`
--

CREATE TABLE `menu` (
  `cod_menu` int(11) NOT NULL,
  `dia` date NOT NULL,
  `calorias_menu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menu_tiene_renglon`
--

CREATE TABLE `menu_tiene_renglon` (
  `id` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `id_renglon` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `nombre_completo` varchar(255) NOT NULL,
  `edad` int(11) NOT NULL,
  `altura` decimal(5,2) NOT NULL,
  `peso_actual` decimal(5,2) NOT NULL,
  `peso_buscado` decimal(5,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglon`
--

CREATE TABLE `renglon` (
  `nro_renglon` int(11) NOT NULL,
  `id_comida` int(11) NOT NULL,
  `cantidad_gramos` decimal(6,2) NOT NULL,
  `sub_total_calorias` decimal(6,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`cod_comida`);

--
-- Indices de la tabla `comida_tiene_ingredientes`
--
ALTER TABLE `comida_tiene_ingredientes`
  ADD PRIMARY KEY (`id_comida`,`id_ingrediente`),
  ADD KEY `id_ingrediente` (`id_ingrediente`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`id_dieta`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `dieta_tiene_menu`
--
ALTER TABLE `dieta_tiene_menu`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_dieta` (`id_dieta`);

--
-- Indices de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  ADD PRIMARY KEY (`id_ingrediente`);

--
-- Indices de la tabla `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`cod_menu`);

--
-- Indices de la tabla `menu_tiene_renglon`
--
ALTER TABLE `menu_tiene_renglon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_renglon` (`id_renglon`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `renglon`
--
ALTER TABLE `renglon`
  ADD PRIMARY KEY (`nro_renglon`),
  ADD KEY `id_comida` (`id_comida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `cod_comida` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `id_dieta` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `dieta_tiene_menu`
--
ALTER TABLE `dieta_tiene_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ingredientes`
--
ALTER TABLE `ingredientes`
  MODIFY `id_ingrediente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menu`
--
ALTER TABLE `menu`
  MODIFY `cod_menu` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `menu_tiene_renglon`
--
ALTER TABLE `menu_tiene_renglon`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `renglon`
--
ALTER TABLE `renglon`
  MODIFY `nro_renglon` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `comida_tiene_ingredientes`
--
ALTER TABLE `comida_tiene_ingredientes`
  ADD CONSTRAINT `comida_tiene_ingredientes_ibfk_1` FOREIGN KEY (`id_comida`) REFERENCES `comida` (`cod_comida`),
  ADD CONSTRAINT `comida_tiene_ingredientes_ibfk_2` FOREIGN KEY (`id_ingrediente`) REFERENCES `ingredientes` (`id_ingrediente`);

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`);

--
-- Filtros para la tabla `dieta_tiene_menu`
--
ALTER TABLE `dieta_tiene_menu`
  ADD CONSTRAINT `dieta_tiene_menu_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`cod_menu`),
  ADD CONSTRAINT `dieta_tiene_menu_ibfk_2` FOREIGN KEY (`id_dieta`) REFERENCES `dieta` (`id_dieta`);

--
-- Filtros para la tabla `menu_tiene_renglon`
--
ALTER TABLE `menu_tiene_renglon`
  ADD CONSTRAINT `menu_tiene_renglon_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`cod_menu`),
  ADD CONSTRAINT `menu_tiene_renglon_ibfk_2` FOREIGN KEY (`id_renglon`) REFERENCES `renglon` (`nro_renglon`);

--
-- Filtros para la tabla `renglon`
--
ALTER TABLE `renglon`
  ADD CONSTRAINT `renglon_ibfk_1` FOREIGN KEY (`id_comida`) REFERENCES `comida` (`cod_comida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

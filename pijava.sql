-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mer. 15 avr. 2020 à 02:21
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pijava`
--

-- --------------------------------------------------------

--
-- Structure de la table `classes`
--

CREATE TABLE `classes` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `session` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `classes`
--

INSERT INTO `classes` (`id`, `name`, `session`) VALUES
(5, '3A6', '2020/2019'),
(6, '3A29', '2019/2020'),
(12, '3A9', '2019/2020');

-- --------------------------------------------------------

--
-- Structure de la table `day`
--

CREATE TABLE `day` (
  `dayName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `day`
--

INSERT INTO `day` (`dayName`) VALUES
('Monday'),
('Tuesday'),
('Wednesday'),
('Thursday'),
('Friday');

-- --------------------------------------------------------

--
-- Structure de la table `exam`
--

CREATE TABLE `exam` (
  `id` int(11) NOT NULL,
  `subject` varchar(50) COLLATE utf8_bin NOT NULL,
  `file` varchar(255) COLLATE utf8_bin NOT NULL,
  `duration` int(11) NOT NULL,
  `date` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `exam`
--

INSERT INTO `exam` (`id`, `subject`, `file`, `duration`, `date`) VALUES
(1, 'math', 'f_5e964c4992095.pdf', 2, '2020-04-30');

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

CREATE TABLE `grade` (
  `id` int(11) NOT NULL,
  `examname` int(11) NOT NULL,
  `grade` float NOT NULL,
  `teacher` varchar(50) COLLATE utf8_bin NOT NULL,
  `pupil` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`id`, `examname`, `grade`, `teacher`, `pupil`) VALUES
(5, 1, 0, 'iuyth', 'rthd');

-- --------------------------------------------------------

--
-- Structure de la table `pupils`
--

CREATE TABLE `pupils` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `birthday` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `classes` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `pupils`
--

INSERT INTO `pupils` (`id`, `fullname`, `birthday`, `email`, `classes`) VALUES
(5, 'ichrak', '2020-04-10', 'ichrakichrak66@gamil.com', 5),
(6, 'mm', '30/03/2012', 'ichrak.harbaoui@esprit.tn', 12),
(11, 'a', '2020-04-10', 'a@a.o', 12),
(13, 'a', '2020-04-08', 'a@a.a', 12),
(16, 'anwar', '2020-04-09', 'ichrakharbaoui4@gmail.com', 5);

-- --------------------------------------------------------

--
-- Structure de la table `subject`
--

CREATE TABLE `subject` (
  `id` int(11) NOT NULL,
  `subjectName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `subject`
--

INSERT INTO `subject` (`id`, `subjectName`) VALUES
(1, 'History'),
(2, 'Geography'),
(3, 'Maths'),
(4, 'English'),
(5, 'Nature Science\r\n'),
(6, 'French'),
(7, 'Arabic');

-- --------------------------------------------------------

--
-- Structure de la table `teacher`
--

CREATE TABLE `teacher` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `phonenumber` varchar(255) COLLATE utf8_bin NOT NULL,
  `specialty` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `teacher`
--

INSERT INTO `teacher` (`id`, `fullname`, `email`, `password`, `phonenumber`, `specialty`) VALUES
(1, 'Asma Hatira', 'asma.hatira@esprit.tn', '0000', '21236254', 'Nothing');

-- --------------------------------------------------------

--
-- Structure de la table `timetable`
--

CREATE TABLE `timetable` (
  `id` int(11) NOT NULL,
  `seance1` varchar(255) NOT NULL,
  `seance2` varchar(255) NOT NULL,
  `seance3` varchar(255) NOT NULL,
  `seance4` varchar(255) NOT NULL,
  `seance5` varchar(255) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `day` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `timetable`
--

INSERT INTO `timetable` (`id`, `seance1`, `seance2`, `seance3`, `seance4`, `seance5`, `id_classe`, `day`) VALUES
(1, 'Geography', 'Maths', 'pause', 'Maths', 'Maths', 5, 'Monday'),
(2, 'Geography', 'Maths', 'pause', 'Maths', 'Maths', 5, 'Tuesday'),
(3, 'Geography', 'Maths', 'pause', 'Maths', 'Maths', 5, 'Wednesday'),
(4, 'Geography', 'Maths', 'pause', 'Maths', 'Maths', 5, 'Thursday');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `exam`
--
ALTER TABLE `exam`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`id`),
  ADD KEY `examname` (`examname`) USING BTREE;

--
-- Index pour la table `pupils`
--
ALTER TABLE `pupils`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `timetable`
--
ALTER TABLE `timetable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_classe` (`id_classe`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `classes`
--
ALTER TABLE `classes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT pour la table `exam`
--
ALTER TABLE `exam`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `grade`
--
ALTER TABLE `grade`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `pupils`
--
ALTER TABLE `pupils`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `subject`
--
ALTER TABLE `subject`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `timetable`
--
ALTER TABLE `timetable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `grade`
--
ALTER TABLE `grade`
  ADD CONSTRAINT `FK` FOREIGN KEY (`examname`) REFERENCES `exam` (`id`);

--
-- Contraintes pour la table `timetable`
--
ALTER TABLE `timetable`
  ADD CONSTRAINT `fk_inv_id_classe` FOREIGN KEY (`id_classe`) REFERENCES `classes` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `timetable_ibfk_1` FOREIGN KEY (`id_classe`) REFERENCES `classes` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

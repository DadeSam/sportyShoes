SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sportyshoes`
--

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'men'),
(2, 'women'),
(3, 'children');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(200) NOT NULL,
  `description` varchar(200) NOT NULL,
  `category_id` int(11) NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `description`, `category_id`, `price`) VALUES
(1, 'Jordans', 'Running Shoes', 3, 800),
(2, 'Converse', 'Running shoes', 2, 1500),
(5, 'Reebok', 'kids shoes', 1, 2000),
(13, 'Vans', 'Casual', 3, 4500),
(14, 'Asics', 'Running shoes', 3, 300),
(16, 'Puma', 'Football shoes', 2, 1200),
(18, 'Adidas', 'Childred unisex', 3,450);

-- --------------------------------------------------------

--
-- Table structure for table `purchased`
--

CREATE TABLE `purchased` (
  `purchased_id` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `date` date NOT NULL,
  `total_amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchased`
--

INSERT INTO `purchased` (`purchased_id`, `username`, `date`, `total_amount`) VALUES
(1, 'Samuel', '2022-04-11', 17000),
(2, 'Etor', '2020-05-10', 4000),
(3, 'Dade', '2023-01-27', 3300);

-- --------------------------------------------------------

--
-- Table structure for table `purchased_item`
--

CREATE TABLE `purchased_item` (
  `purchased_item_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `purchased_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchased_item`
--

INSERT INTO `purchased_item` (`purchased_item_id`, `product_id`, `purchased_id`, `quantity`) VALUES
(13, 2, 1, 2),
(14, 5, 1, 3),
(15, 5, 2, 3),
(16, 16, 3, 1),
(17, 14, 3, 100),
(18, 14, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email_address` varchar(200) NOT NULL,
  `location` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `email_address`, `location`) VALUES
('Desmond', 'Desmond', 'desmond@gmail.com', 'Airport Accra'),
('Samuel', 'Samuel', 'samuel@gmail.com', 'Marylan USA'),
('Dade', 'Dade', 'dade@gmail.com', 'Madina Ghana');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`),
  ADD KEY `category_id` (`category_id`);

--
-- Indexes for table `purchased`
--
ALTER TABLE `purchased`
  ADD PRIMARY KEY (`purchased_id`),
  ADD KEY `username` (`username`);

--
-- Indexes for table `purchased_item`
--
ALTER TABLE `purchased_item`
  ADD PRIMARY KEY (`purchased_item_id`),
  ADD KEY `product_id` (`product_id`),
  ADD KEY `purchased_id` (`purchased_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `purchased`
--
ALTER TABLE `purchased`
  MODIFY `purchased_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `purchased_item`
--
ALTER TABLE `purchased_item`
  MODIFY `purchased_item_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`);

--
-- Constraints for table `purchased`
--
ALTER TABLE `purchased`
  ADD CONSTRAINT `purchased_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Constraints for table `purchased_item`
--
ALTER TABLE `purchased_item`
  ADD CONSTRAINT `purchased_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`),
  ADD CONSTRAINT `purchased_item_ibfk_3` FOREIGN KEY (`purchased_id`) REFERENCES `purchased` (`purchased_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

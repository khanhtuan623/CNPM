-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost
-- Thời gian đã tạo: Th4 20, 2019 lúc 03:19 PM
-- Phiên bản máy phục vụ: 10.1.32-MariaDB
-- Phiên bản PHP: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `CarRentalManagement`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `CAR`
--

CREATE TABLE `CAR` (
  `IdCar` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `Driver1` int(4) NOT NULL,
  `Driver2` int(4) NOT NULL,
  `Other` varchar(3000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `CAR`
--

INSERT INTO `CAR` (`IdCar`, `Driver1`, `Driver2`, `Other`) VALUES
('99B1-00188', 1002, 1004, 'thieu thong tin'),
('99B1-18801', 1000, 1001, 'chua co thong tin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `CUSTOMER`
--

CREATE TABLE `CUSTOMER` (
  `Tel` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `FullName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Address` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IdentifyNumber` varchar(20) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `CUSTOMER`
--

INSERT INTO `CUSTOMER` (`Tel`, `FullName`, `Address`, `Email`, `IdentifyNumber`) VALUES
('0363674897', 'Tuan', '6 nguyen thi thap quan 7', 'khanhtuan697@gmail.com', '125714623');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `DRIVER`
--

CREATE TABLE `DRIVER` (
  `IdDriver` int(4) NOT NULL,
  `NameDriver` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Tel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Experience` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `Other` varchar(3000) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `DRIVER`
--

INSERT INTO `DRIVER` (`IdDriver`, `NameDriver`, `Tel`, `Experience`, `Other`) VALUES
(1000, 'Tran Khanh Tuan', '0363674897', 'co hon 1 nam kinh nghiem trong linh vuc giao thong van tai', 'thieu thong tin'),
(1001, 'Nguyen Thanh Tuan', '0987654321', 'khong co kinh nghiem', 'thieu thong tin'),
(1002, 'TRAN HOANG PHONG', '097124124', 'chua co kinh nghiem', 'thieu thong tin'),
(1003, 'Nguyen Phuong Nam', '0129312323', 'chua co kinh nghiem', 'thieu thong tin'),
(1004, 'Tran Hoang Long', '0192321321', 'chua co kinh nghiem', 'thieu thong tin'),
(1005, 'Hoang Thanh Phong', '0999999999', 'chua co kinh nghiem', 'thieu thong tin'),
(1006, 'Ha Thien Nhan', '099891929', 'thieu kinh nghiem', 'chua co thong tin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `SCHEDULE`
--

CREATE TABLE `SCHEDULE` (
  `IdSchedule` int(4) NOT NULL,
  `NameChannel` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Space` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `Number` smallint(2) NOT NULL,
  `TimeOfDeparture` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ArrivalTime` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IdCar` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `SCHEDULE`
--

INSERT INTO `SCHEDULE` (`IdSchedule`, `NameChannel`, `Space`, `Number`, `TimeOfDeparture`, `ArrivalTime`, `IdCar`) VALUES
(1000, 'HCM-HN', '1700km', 99, '2019-04-02 01:00:00.000000', '2019-04-02 03:00:00.000000', '99B1-18801'),
(1001, 'HCM-NHATRANG', '500km', 10, '8:00 20/04/2019', '12:00 20/04/2019', '99B1-00188');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `SHOPPINGCART`
--

CREATE TABLE `SHOPPINGCART` (
  `IdNo` int(4) NOT NULL,
  `DateOfDeparture` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `IdTicket` int(4) NOT NULL,
  `Chair` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Total` smallint(2) NOT NULL,
  `Tel` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `IdMethod` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Status` smallint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `SHOPPINGCART`
--

INSERT INTO `SHOPPINGCART` (`IdNo`, `DateOfDeparture`, `IdTicket`, `Chair`, `Total`, `Tel`, `IdMethod`, `Status`) VALUES
(1000, '2019-04-11', 0, '24', 2, '0363674897', 'cash', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `TICKETFARE`
--

CREATE TABLE `TICKETFARE` (
  `IdTicket` int(4) NOT NULL,
  `IdSchedule` int(4) NOT NULL,
  `StartingPost` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Destination` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `Price` int(10) NOT NULL,
  `Note` varchar(500) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `TICKETFARE`
--

INSERT INTO `TICKETFARE` (`IdTicket`, `IdSchedule`, `StartingPost`, `Destination`, `Price`, `Note`) VALUES
(1000, 1001, 'bến xe hoa mai quận 1', 'bến xe nha trang,TP.Nha Trang', 99000, 'thieu thong tin');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `USER`
--

CREATE TABLE `USER` (
  `IdUser` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `FullName` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `USER`
--

INSERT INTO `USER` (`IdUser`, `Password`, `Email`, `FullName`) VALUES
('khanhtuan623', '123456', 'khanhtuan697@gmail.com', 'Tran Khanh Tuan'),
('ThanhTuan623', '123', 'ThanhTuan623@gmail.com', 'Nguyen Thanh Tuan');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `CAR`
--
ALTER TABLE `CAR`
  ADD PRIMARY KEY (`IdCar`);

--
-- Chỉ mục cho bảng `CUSTOMER`
--
ALTER TABLE `CUSTOMER`
  ADD PRIMARY KEY (`Tel`);

--
-- Chỉ mục cho bảng `DRIVER`
--
ALTER TABLE `DRIVER`
  ADD PRIMARY KEY (`IdDriver`);

--
-- Chỉ mục cho bảng `SCHEDULE`
--
ALTER TABLE `SCHEDULE`
  ADD PRIMARY KEY (`IdSchedule`),
  ADD KEY `IdCar` (`IdCar`);

--
-- Chỉ mục cho bảng `SHOPPINGCART`
--
ALTER TABLE `SHOPPINGCART`
  ADD PRIMARY KEY (`IdNo`),
  ADD KEY `IdTicket` (`IdTicket`),
  ADD KEY `Tel` (`Tel`);

--
-- Chỉ mục cho bảng `TICKETFARE`
--
ALTER TABLE `TICKETFARE`
  ADD PRIMARY KEY (`IdTicket`),
  ADD KEY `IdChannel` (`IdSchedule`);

--
-- Chỉ mục cho bảng `USER`
--
ALTER TABLE `USER`
  ADD PRIMARY KEY (`IdUser`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `DRIVER`
--
ALTER TABLE `DRIVER`
  MODIFY `IdDriver` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

--
-- AUTO_INCREMENT cho bảng `SCHEDULE`
--
ALTER TABLE `SCHEDULE`
  MODIFY `IdSchedule` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1002;

--
-- AUTO_INCREMENT cho bảng `SHOPPINGCART`
--
ALTER TABLE `SHOPPINGCART`
  MODIFY `IdNo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001;

--
-- AUTO_INCREMENT cho bảng `TICKETFARE`
--
ALTER TABLE `TICKETFARE`
  MODIFY `IdTicket` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1001;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

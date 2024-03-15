CREATE TABLE `usermodel` (
	`id` SERIAL NOT NULL,
	`username` VARCHAR(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	`password` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;


CREATE TABLE `jobs` (
  `jobID` integer NOT NULL primary key autoincrement,
  `jobTitle` varchar(255) NOT NULL default '',
  `organization` varchar(255) NOT NULL default '',
  `country` varchar(50) NOT NULL default '',
  `expiryDate` date NOT NULL default '0000-00-00',
  `closingDate` date NOT NULL default '0000-00-00',
  `description` text NOT NULL,
  `postedDate` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `isVisible` integer NOT NULL default '0',
  `subrEmail` varchar(255) NOT NULL default ''
);

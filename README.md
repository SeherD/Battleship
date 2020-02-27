# Battleship
Battleship is a collection of classes that work together to simulate the classic board game, Battleship.
The project can be found at https://github.com/SeherD/Battleship.git

# Description
The Control package contains, Launcher.java that starts the game and Utilities.java that provide start and end game messages.
The Game package contains, Board.java and Tile.java to form the game board and tile coordinates.
The Player Package contains, Turn.java that takes user input and places ships and attacks opponent based on the input coordinates.
The Ships Package contains, abstract parent class Ship.java and it's 5 sub classes of 5 different kind of ships in the game: Carrier.java, Cruiser.java, Destroyer.java, PatrolBoat.java and Submarine.java.

# Installation
Download the following packages in the same folder: Control, Game, Player and Ships. The text version of the game can be run by, Command to change Directory- cd Battleship-master then Command to compile- javac Control/Launcher.java and Command to run - java Control.Launcher

# Usage 
The input is expected in the following forms to prompt the user for  locations of where they want to place their battleships and where they want to attack, the game is played on a board size of 10x10. When asked for inputs of the start coordinate, enter the number pair in the form of x, y. When asked for the inputs of the end coordinates, enter the number pair in the form x, y (End coordinates will depend on the size of the ship, for Example: "Enter the end cordinates of the Carrier 5" the #5 indicates the ship's size), and once all ships are placed on the board, users will be prompted to enter in coordinates in the form x, y for where they would like to target their opponent. The goal of the user is to hit all locations of the opponents ships without losing their ships first. If all ships of a player have been destroyed, the game will end and the player with surviving ships wins.

# Authors
T2G6: Seher Dawar, Tian Xia, Spencer Luong and Jessica Tran

# Year
Project started Feburary 2020, Status: In progress 

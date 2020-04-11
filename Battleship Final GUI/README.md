# Battleship
Battleship is a collection of classes that work together to simulate the classic board game, Battleship.
The project can be found at https://github.com/SeherD/Battleship.git
Please navigate to the folder "Battleship Demo 3" for the GUI code.

# Description
The Control package contains Launcher.java that starts the game/GUI and Utilities.java that provide end game pop up messages. The Game package contains Board.java and Tile.java to form the game board and tile coordinates. The Player Package contains Turn.java that takes user input and places ships and attacks opponent. The Ships Package contains the abstract parent class Ship.java and its 5 sub classes of 5 different kinds of ships in the game: Carrier, Cruiser, Destroyer, PatrolBoat and Submarine.

# Installation
Go into the folder "Battleship Demo 3" and download the following packages in the same folder: Control, Game, Player and Ships, as well as all the media files(images and music). The GUI version of the game can be run in the command line by, Command to change Directory- cd Battleship-master then Command to compile- javac Control/Launcher.java and Command to run - java Control.Launcher

# Usage 
***Demo 3 updates:
In the Timed Mode, please click on the timer start button after all the ships are placed on the left board.
On the main menu, the user can select one of two game modes - Regular and Timed. In-game instruction is available when Help button is clicked. On the upper right corner, music button and switched on and off for background music.

Battleship is played on a board size of 10x10. The input is expected in the following forms to where the user want to place their battleships and where they want to attack: 

User input is binded with left and right mouse clicks. 

The user will be able place their ships on the left-hand side grid. Left mouse clicks will place ships horizontally and right mouse clicks will place ships vertically. Users will not be able to overlap ships nor place ships outside of the board. Computer's ship placement is randomized and adheres to the same rules as the user.

Once all ships are placed on the board, users will be able to attack their opponent using the right-hand side grid. Users can click anywhere on the 10x10 grid, to target and attack their opponent users will left click where they would like the attack. The goal of the user is to hit all locations of the opponents ships without losing their ships first. If all ships of one player have been destroyed, the game will end and the player with surviving ships wins and a pop up message will appear declaring the winner.

# Authors
T2G6: Seher Dawar, Tian Xia, Spencer Luong and Jessica Tran

# Year
Project started in February 2020, Status: Text-based version completed. GUI and AI improved.

# Updates
Timed Mode, In-game instructions, background music, error/illegal moves handling, improved and challenging AI.

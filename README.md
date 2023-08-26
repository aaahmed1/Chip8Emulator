# Chip8Emulator
Emulator written in Java for the CHIP-8 language. A selection of CHIP-8 games are included in the c8games folder.
## Installation
1. Clone the repository
2. Change directory to Chip8Emulator
3. Do `./gradlew run` or `gradlew.bat run` if you're on Windows. 
## Usage
If you want to choose a different game, you need to change the file path in line 13 of Main.java to "c8games/(name of game in c8games folder)". The following keyboard layout is used:
```
1 | 2 | 3 | 4
Q | W | E | R
A | S | D | F
Z | X | C | V
```
Unfortunately, the games didn't come with instructions. So you need figure out the controls yourself. But for Space Invaders, Q goes left, W shoots, and E goes right.

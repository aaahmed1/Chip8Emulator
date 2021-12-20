package emulator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Chip8 {
    int opcode = 0;
    int[] memory = new int[4096];
    int[] V = new int[16];
    int I = 0;
    int pc = 0x200;
    int[][] gfx = new int[192][394];
    int delayTimer = 0;
    int soundTimer = 0;
    int[] stack = new int[16];
    int sp = 0;
    int[] key = new int[16];
    boolean[] isPressed = new boolean[1];
    boolean drawFlag = false;
    int[] pressedKey = new int[1];
    //Display display;
    //Keyboard keyboard;

    int[] chip8FontSet =
            {
                    0xF0, 0x90, 0x90, 0x90, 0xF0, // 0
                    0x20, 0x60, 0x20, 0x20, 0x70, // 1
                    0xF0, 0x10, 0xF0, 0x80, 0xF0, // 2
                    0xF0, 0x10, 0xF0, 0x10, 0xF0, // 3
                    0x90, 0x90, 0xF0, 0x10, 0x10, // 4
                    0xF0, 0x80, 0xF0, 0x10, 0xF0, // 5
                    0xF0, 0x80, 0xF0, 0x90, 0xF0, // 6
                    0xF0, 0x10, 0x20, 0x40, 0x40, // 7
                    0xF0, 0x90, 0xF0, 0x90, 0xF0, // 8
                    0xF0, 0x90, 0xF0, 0x10, 0xF0, // 9
                    0xF0, 0x90, 0xF0, 0x90, 0x90, // A
                    0xE0, 0x90, 0xE0, 0x90, 0xE0, // B
                    0xF0, 0x80, 0x80, 0x80, 0xF0, // C
                    0xE0, 0x90, 0x90, 0x90, 0xE0, // D
                    0xF0, 0x80, 0xF0, 0x80, 0xF0, // E
                    0xF0, 0x80, 0xF0, 0x80, 0x80  // F
            };


    public Chip8() {
        for (int i = 0; i < 80; i++) memory[i] = chip8FontSet[i];
        pressedKey[0] = -1;
        //this.display = new Display(gfx);
        //display.initialize();
        //this.keyboard = new Keyboard(this.display.panel, this.key, this.isPressed);

    }

    public void loadGame(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        byte[] fileContents =  Files.readAllBytes(path);
        for (int i = 0; i < fileContents.length; i++) memory[i + 512] = (fileContents[i] & 0xFF);
    }

    public void emulateCycle() throws InterruptedException {
        opcode = memory[pc] << 8 | memory[pc + 1];
        opcode &= 0xFFFF;
        switch (opcode & 0xF000) {
            case 0x0000:
                switch (opcode & 0x000F) {
                    case 0x0000:
                        for (int[] arr : gfx) {
                            Arrays.fill(arr, 0);
                        }
                        drawFlag = true;
                        pc += 2;
                        break;
                    case 0x000E:
                        pc = stack[sp - 1];
                        sp--;
                        pc += 2;
                        break;
                    default:
                        System.out.println("Unknown opcode: " + Integer.toHexString(opcode) + " at " + pc);
                }
                break;
            case 0x1000:
                pc = opcode & 0x0FFF;
                break;
            case 0x2000:
                stack[sp] = pc;
                sp++;
                pc = opcode & 0x0FFF;
                break;
            case 0x3000:
                if (V[(opcode & 0x0F00) >> 8] == (opcode & 0x00FF)) pc += 2;
                pc += 2;
                break;
            case 0x4000:
                if (V[(opcode & 0x0F00) >> 8] != (opcode & 0x00FF)) pc += 2;
                pc += 2;
                break;
            case 0x5000:
                if (V[(opcode & 0x0F00) >> 8] == V[(opcode & 0x00F0) >> 4]) pc += 2;
                pc += 2;
                break;
            case 0x6000:
                V[(opcode & 0x0F00) >> 8] = opcode & 0x00FF;
                pc += 2;
                break;
            case 0x7000:
                V[(opcode & 0x0F00) >> 8] += opcode & 0x00FF;
                V[(opcode & 0x0F00) >> 8] &= 0xFF;
                pc += 2;
                break;
            case 0x8000:
                switch (opcode & 0x000F) {
                    case 0x0000:
                        V[(opcode & 0x0F00) >> 8] = V[(opcode & 0x00F0) >> 4];
                        pc += 2;
                        break;
                    case 0x0001:
                        V[(opcode & 0x0F00) >> 8] = V[(opcode & 0x0F00) >> 8] | V[(opcode & 0x00F0) >> 4];
                        pc += 2;
                        break;
                    case 0x0002:
                        V[(opcode & 0x0F00) >> 8] = V[(opcode & 0x0F00) >> 8] & V[(opcode & 0x00F0) >> 4];
                        pc += 2;
                        break;
                    case 0x0003:
                        V[(opcode & 0x0F00) >> 8] = V[(opcode & 0x0F00) >> 8] ^ V[(opcode & 0x00F0) >> 4];
                        pc += 2;
                        break;
                    case 0x0004:
                        V[(opcode & 0x0F00) >> 8] += V[(opcode & 0x00F0) >> 4];
                        if (V[(opcode & 0x0F00) >> 8] > 0x00FF) V[0xF] = 1;
                        else V[0xF] = 0;
                        V[(opcode & 0x0F00) >> 8] &= 0xFF;
                        pc += 2;
                        break;
                    case 0x0005:
                        V[(opcode & 0x0F00) >> 8] -= V[(opcode & 0x00F0) >> 4];
                        if (V[(opcode & 0x0F00) >> 8] > 0) V[0xF] = 1;
                        else V[0xF] = 0;
                        V[(opcode & 0x0F00) >> 8] &= 0xFF;
                        pc += 2;
                        break;
                    case 0x0006:
                        if (Integer.lowestOneBit(V[(opcode & 0x0F00) >> 8]) == 1) V[0xF] = 1;
                        else V[0xF] = 0;
                        V[(opcode & 0x0F00) >> 8] /= 2;
                        pc += 2;
                        break;
                    case 0x0007:
                        V[(opcode & 0x0F00) >> 8] = V[(opcode & 0x00F0) >> 4] - V[(opcode & 0x0F00) >> 8];
                        if (V[(opcode & 0x0F00) >> 8] > 0) V[0xF] = 1;
                        else V[0xF] = 0;
                        V[(opcode & 0x0F00) >> 8] &= 0xFF;
                        pc += 2;
                        break;
                    case 0x000E:
                        if (Integer.highestOneBit(V[(opcode & 0x0F00) >> 8]) == 128) V[0xF] = 1;
                        else V[0xF] = 0;
                        V[(opcode & 0x0F00) >> 8] *= 2;
                        V[(opcode & 0x0F00) >> 8] &= 0xFF;
                        pc += 2;
                        break;
                    default:
                        System.out.println("Unknown opcode: " + Integer.toHexString(opcode) + " at " + pc);
                }
                break;
            case 0x9000:
                if (V[(opcode & 0x0F00) >> 8] != V[(opcode & 0x00F0) >> 4]) pc += 2;
                pc += 2;
                break;
            case 0xA000:
                I = opcode & 0x0FFF;
                pc += 2;
                break;
            case 0xB000:
                pc = (opcode & 0x0FFF) + V[0];
                break;
            case 0xC000:
                V[(opcode & 0x0F00) >> 8] = (int)(Math.random() * 256) & (opcode & 0x00FF);
                pc += 2;
                break;
            case 0xD000:
                int x = V[(opcode & 0x0F00) >> 8];
                int y = V[(opcode & 0x00F0) >> 4];
                int height = opcode & 0x000F;
                int pixel;

                V[0xF] = 0;
                for (int yline = 0; yline < height; yline++) {
                    pixel = memory[I + yline];
                    for (int xline = 0; xline < 8; xline++) {
                        if ((pixel & (0x80 >> xline)) != 0) {
                            if (gfx[(x + xline) % 192][(y + yline) % 394] == 1) V[0xF] = 1;
                            gfx[(x + xline) % 192][(y + yline) % 394] ^= 1;
                            //System.out.println(gfx[(x + xline) % 32][(y + yline) % 64]);
                        }
                    }
                }
                drawFlag = true;
                pc += 2;
                break;
            case 0xE000:
                switch (opcode & 0x00F0) {
                    case 0x0090:
                        //System.out.println(Integer.toHexString(opcode));
                        if (key[V[(opcode & 0x0F00) >> 8]] == 1) pc += 4;
                        else pc += 2;
                        break;
                    case 0x00A0:
                        //System.out.println(Integer.toHexString(opcode));
                        if (key[V[(opcode & 0x0F00) >> 8]] != 1) pc += 2;
                        pc += 2;
                        break;
                    default:
                        System.out.println("Unknown opcode: " + Integer.toHexString(opcode) + " at " + pc);
                }
                break;
            case 0xF000:
                switch (opcode & 0x00FF) {
                    case 0x0007:
                        V[(opcode & 0x0F00) >> 8] = delayTimer;
                        pc += 2;
                        break;
                    case 0x000A:
                        while (!isPressed[0]) {
                            Thread.sleep(1);
                        }
                        V[(opcode & 0x0F00) >> 8] = pressedKey[0];
                        pc += 2;
                        break;
                    case 0x0015:
                        delayTimer = V[(opcode & 0x0F00) >> 8];
                        pc += 2;
                        break;
                    case 0x0018:
                        soundTimer = V[(opcode & 0x0F00) >> 8];
                        pc += 2;
                        break;
                    case 0x001E:
                        I += V[(opcode & 0x0F00) >> 8];
                        pc += 2;
                        break;
                    case 0x0029:
                        I = V[(opcode & 0x0F00) >> 8] * 5;
                        pc += 2;
                        break;
                    case 0x0033:
                        memory[I] = V[(opcode & 0x0F00) >> 8] / 100;
                        memory[I + 1] = (V[(opcode & 0x0F00) >> 8] / 10) % 10;
                        memory[I + 2] = (V[(opcode & 0x0F00) >> 8] % 100) % 10;
                        pc += 2;
                        break;
                    case 0x0055:
                        for (int i = 0; i <= (opcode & 0x0F00) >> 8; i++) {
                            memory[I + i] = V[i];
                        }
                        pc += 2;
                        break;
                    case 0x0065:
                        for (int i = 0; i <= (opcode & 0x0F00) >> 8; i++) {
                            V[i] = memory[I + i] & 0xFF;
                        }
                        pc += 2;
                        break;
                    default:
                        System.out.println("Unknown opcode: " + Integer.toHexString(opcode) + " at " + pc);

                }
                break;
            default:
                System.out.println("Unknown opcode: " + Integer.toHexString(opcode) + " at " + pc);
        }
        if (delayTimer > 0) delayTimer--;
        if (soundTimer > 0) {
            if (soundTimer == 1) System.out.println("BEEP");
            soundTimer--;
        }
        //System.out.println(Integer.toHexString(opcode));

        /*
        int numOnes = 0;
        for (int i = 0; i < gfx.length; i++) {
            for (int k = 0; k < gfx[0].length; k++) {
                if (gfx[i][k] == 1) numOnes++;
            }
        }
        System.out.println(Integer.toHexString(opcode) + " with numOnes: " + numOnes);

         */


    }



}

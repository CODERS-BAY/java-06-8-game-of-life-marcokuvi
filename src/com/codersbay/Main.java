package com.codersbay;


import java.util.Scanner;

public class Main {

    public static int[][] plantSeed() {

        System.out.print("No Cells");
        System.out.println("\n");

        int[][] grid = new int[10][10];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0)
                    System.out.print(0);
                else
                    System.out.print(1);
            }
            System.out.println();
        }
        System.out.println("\n");
        return grid;
    }

    public static void findNextGeneration() {

        Scanner input = new Scanner(System.in);
        System.out.println("Do you want to start the next Generation");

        if (input.hasNext("yes")) {

            int[][] gridPlanted = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                    {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                    {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
            };
            int[][] nextGenerationgrid = new int[10][10];


            for (int l = 1; l < nextGenerationgrid.length - 1; l++) {
                for (int m = 1; m < nextGenerationgrid.length - 1; m++) {

                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            aliveNeighbours += gridPlanted[l + i][m + j];


                    aliveNeighbours -= gridPlanted[l][m];


                    if ((gridPlanted[l][m] == 1) && (aliveNeighbours < 2))
                        nextGenerationgrid[l][m] = 0;


                    else if ((gridPlanted[l][m] == 1) && (aliveNeighbours > 3))
                        nextGenerationgrid[l][m] = 0;


                    else if ((gridPlanted[l][m] == 0) && (aliveNeighbours == 3))
                        nextGenerationgrid[l][m] = 1;


                    else
                        nextGenerationgrid[l][m] = gridPlanted[l][m];


                    System.out.println();


                    for (int i = 0; i < gridPlanted.length; i++) {
                        for (int j = 0; j < gridPlanted.length; j++) {
                            if (nextGenerationgrid[i][j] == 0)
                                System.out.print("0");
                            else
                                System.out.print("1");
                        }
                        System.out.println();
                    }
                }
            }
        } else {
            System.out.println("You don't want to start the new Generation");
            input.close();
        }
    }

    public static void main(String[] args) {
        plantSeed();
        findNextGeneration();
    }
}
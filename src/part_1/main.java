package part_1;

import java.util.Random;
import java.util.Scanner;

public class main {
    // pre-requirements
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static boolean running = true;
    public static int[] arr = new int[0];

    // main part
    public static void main(String[] args) {
        while (running) {
            greeting();
            int choice = readIntInput("Enter option: ");
            program(choice);
        }
    }

    // program logic
    public static void program(int choice) {
        switch (choice) {
            case 1:
                arr = createArray();
                break;
            case 2:
                arr = createArrayRandom();
                break;
            case 3:
                print(arr);
                break;
            case 4:
                bubbleSort(arr);
                break;
            case 5:
                bubbleSortS(arr);
                break;
            case 6:
                running = false;
                print("Exiting program...");
                break;
            default:
                print("Invalid choice. Please try again.");
        }
    }

    // main menu
    public static void greeting() {
        String[] menuOptions = {
                "\n        ARRAY MENU     ",
                "1. Create array manually",
                "2. Create array with random elements",
                "3. Print array",
                "4. Sort array",
                "5. Sort array with Snap-Shots",
                "6. Exit"
        };

        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

    // manual array creation method
    public static int[] createArray() {
        int size = readPositiveIntInput();
        int[] arr = new int[size];

        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = readIntInput("Element #" + (i + 1) + ": ");
        }
        return arr;
    }

    // random array creation method
    public static int[] createArrayRandom() {
        int size = readPositiveIntInput();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    // bubble sort method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // bubble sort with Snap-Shots method
    public static void bubbleSortS(int[] arr) {
        if (arr.length == 0) {
            print("Array is empty. Nothing to sort.");
        } else {
            int n = arr.length;

            // Initial array
            System.out.println("\nInitial array:");
            print(arr);
            System.out.println();

            // Iteration count
            for (int i = 0; i < n - 1; i++) {
                System.out.println("Outer loop, iteration #" + (i + 1) + ":");
                print(arr);
                System.out.println("\nInner loop:");

                // bubble-sorting
                for (int j = 0; j < n - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }

                    // Printing Snap-Shots
                    System.out.print("Iteration #" + (j + 1) + ": ");
                    print(arr, j);
                }
                System.out.println();
            }
        }
        print("Array sorted successfully.");
    }

    // HELPER METHODS

    // print String
    public static void print(String msg) {
        System.out.println(msg);
    }

    // print array
    public static void print(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty.");
            return;
        }
        System.out.print("Your array: ");
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    // print snapshots
    private static void print(int[] arr, int comparedIndex) {
        String BOLD_RED = "\u001B[1;31m";
        String RESET = "\u001B[0m";
        for (int k = 0; k < arr.length; k++) {
            if (k == comparedIndex || k == comparedIndex + 1) {
                System.out.print(BOLD_RED + arr[k] + RESET + " ");
            } else {
                System.out.print(arr[k] + " ");
            }
        }
        System.out.println();
    }

    // read if integer
    private static int readIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    // read if positive
    private static int readPositiveIntInput() {
        while (true) {
            int val = readIntInput("Enter the size of the array: ");
            if (val >= 0) {
                return val;
            }
            System.out.println("Size cannot be negative. Try again.");
        }
    }
}
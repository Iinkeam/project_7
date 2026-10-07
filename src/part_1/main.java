package part_1;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static boolean running = true;
    public static int[] arr = new int[0];

    public static void main(String[] args) {
        while (running) {
            greeting();
            int choice = readIntInput("Enter option: ");
            program(choice);
        }
    }

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
                if (arr.length == 0) {
                    print("Array is empty. Nothing to sort.");
                } else {
                    bubbleSort(arr);
                    print("Array sorted successfully.");
                }
                break;
            case 5:
                running = false;
                print("Exiting program...");
                break;
            default:
                print("Invalid choice. Please try again.");
        }
    }

    public static int[] createArray() {
        int size = readPositiveIntInput("Enter the size of the array: ");
        int[] arr = new int[size];

        System.out.println("Enter " + size + " integer elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = readIntInput("Element #" + (i + 1) + ": ");
        }
        return arr;
    }

    public static int[] createArrayRandom() {
        int size = readPositiveIntInput("Enter the size of the array: ");
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void greeting() {
        String[] menuOptions = {
                "\n        ARRAY MENU     ",
                "1. Create array manually",
                "2. Create array with random elements",
                "3. Print array",
                "4. Sort array",
                "5. Exit"
        };

        for (String option : menuOptions) {
            System.out.println(option);
        }
    }

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

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        System.out.println("\nInitial array:");
        print(arr);
        System.out.println();

        for (int i = 0; i < n - 1; i++) {
            System.out.println("Outer loop, iteration " + (i + 1) + ":");
            print(arr);
            System.out.println("\nInner loop:");

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

                System.out.print("iteration " + (j + 1) + ": ");
                printSnapshot(arr, j);
            }
            System.out.println();
        }
    }

    public static String BOLD_RED = "\u001B[1;31m";
    public static String RESET = "\u001B[0m";

    private static void printSnapshot(int[] arr, int comparedIndex) {
        for (int k = 0; k < arr.length; k++) {
            if (k == comparedIndex || k == comparedIndex + 1) {
                System.out.print(BOLD_RED + arr[k] + RESET + " ");
            } else {
                System.out.print(arr[k] + " ");
            }
        }
        System.out.println();
    }

    public static void print(String msg) {
        System.out.println(msg);
    }

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

    private static int readPositiveIntInput(String prompt) {
        while (true) {
            int val = readIntInput(prompt);
            if (val >= 0) {
                return val;
            }
            System.out.println("Size cannot be negative. Try again.");
        }
    }
}
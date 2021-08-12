
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        while (true) {
            //Step 1: // step 1: Display a menu and enter your choice 
            showMenu();
            int choice = getInputChoice();
            //step 2 Perform function on the selected option.
            switch (choice) {
                // check options with each right case 
                case 1:
                    displayMatrix(additionMatrix());
                    break;
                case 2:
                    displayMatrix(subtractionMatrix());
                    break;
                case 3:
                    displayMatrix(multiplicationMatrix());
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }

    // Show menu 
    private static void showMenu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtration Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Please choice 1 option: ");
    }

    // get value of your choice exactly format  
    private static int getInputChoice() {
        Scanner sc = new Scanner(System.in);
        //  run the loop untill user enter right input number of choice
        while (true) {
            // check exception input for number
            try {
                int number = Integer.parseInt(sc.nextLine());
                // check if user enter number outer range
                if ((number <= 4) && (number >= 1)) {
                    return number;
                } else {
                    System.err.println("out of range 1 to 4");
                    System.out.print("Please enter again: ");
                }
            } catch (NumberFormatException e) { // check if number is not format
                System.err.println("Must be a Ingeger number");
                System.out.print("Please enter again: ");
            }
        }
    }
    // get value of Integer number exactly format  
    private static int getInputInteger() {
        Scanner sc = new Scanner(System.in);
        //  run the loop untill user enter right input number integer
        while (true) {
            // check exception input for number
            try {
                int result = Integer.parseInt(sc.nextLine());
                return result;
            } catch (NumberFormatException e) { // check if number is not format
                System.err.println("Value of matrix is digit");
                System.out.print("Re-enter: ");
            }
        }
    }

    private static int[][] getInputMatrix(int number) {
        System.out.print("Enter Row Matrix " + number + ": ");
        int row = getInputInteger();
        System.out.print("Enter Colum Matrix " + number + ": ");
        int col = getInputInteger();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = getInputInteger();
            }
        }
        return matrix;
    }

    private static int[][] getInputMatrix2(int number, int col1) {
        System.out.print("Enter Row Matrix " + number + ": ");
        int row = getInputInteger();
        if (col1 != row) {
            System.err.println("Can't multiple");
            System.out.println("");
            return null;
        }
        System.out.print("Enter Colum Matrix " + number + ": ");
        int col = getInputInteger();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = getInputInteger();
            }
        }
        return matrix;
    }

    private static int[][] getInputMatrix2(int number, int col1, int row1) {
        System.out.print("Enter Row Matrix " + number + ": ");
        int row = getInputInteger();
        if (row != row1) {
            System.err.println("Can't caculate ");
            System.out.println("");
            return null;
        }
        System.out.print("Enter Colum Matrix " + number + ": ");
        int col = getInputInteger();
        if (col != col1) {
            System.err.println("Can't caculate ");
            System.out.println("");
            return null;
        }
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + number + "[" + (i + 1) + "]" + "[" + (j + 1) + "]:");
                matrix[i][j] = getInputInteger();
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public static int[][] additionMatrix() {
        System.out.println("--------- Addition -----------");
        int matrix1[][] = getInputMatrix(1);
        int matrix2[][] = getInputMatrix2(2, matrix1.length, matrix1[0].length);
        if (matrix2 == null) {
            return null;
        }
        System.out.println("--------- Result -------------");
        displayMatrix(matrix1);
        System.out.println("+");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public static int[][] subtractionMatrix() {
        System.out.println("--------- Subtraction ----------");
        int matrix1[][] = getInputMatrix(1);
        int matrix2[][] = getInputMatrix2(2, matrix1.length, matrix1[0].length);
        if (matrix2 == null) {
            return null;
        }
        System.out.println("--------- Result -------------");
        displayMatrix(matrix1);
        System.out.println("-");
        displayMatrix(matrix2);
        System.out.println("=");
        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public static int[][] multiplicationMatrix() {
        System.out.println("--------- Multiplication -----------");
        int matrix1[][] = getInputMatrix(1);
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int matrix2[][] = getInputMatrix2(2, col1);
        if (matrix2 == null) {
            return null;
        }
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        System.out.println("--------- Result -------------");
        displayMatrix(matrix1);
        System.out.println("*");
        displayMatrix(matrix2);
        System.out.println("=");
        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return matrixResult;
    }
}

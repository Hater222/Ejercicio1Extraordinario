
package main;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DeterminanteMatriz {

    public static void main(String[] args) {
        String inputFile = "input.txt";  // Nombre del archivo de entrada
        try {
            double[][] matrix = readMatrixFromFile(inputFile);

            double det = determinante(matrix);
            System.out.println("Determinante: " + det);

        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("La matriz no es cuadrada: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error de formato en los valores de la matriz: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("La matriz no tiene el tamaño correcto: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error inesperado: " + e.getMessage());
        }
    }

    static double determinante(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            throw new IllegalStateException("Matriz tiene que ser cuadrada");
        }

        if (matrix.length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinante(minor(matrix, 0, i));
        }
        return det;
    }

    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i != row && j < matrix[i].length; j++) {
                if (j != column) {
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
                }
            }
        }

        return minor;
    }

    public static double[][] readMatrixFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int numRows = 0;
        int numCols = 0;

        // Contar el número de filas y columnas en el archivo
        while ((line = reader.readLine()) != null) {
            String[] values = line.trim().split("\\s+");
            numCols = values.length;
            numRows++;
        }

        reader.close();

        if (numRows == 0 || numCols == 0) {
            throw new IOException("El archivo está vacío o no contiene valores de matriz");
        }

        double[][] matrix = new double[numRows][numCols];
        reader = new BufferedReader(new FileReader(filePath));
        int row = 0;

        // Leer los valores del archivo y construir la matriz
        while ((line = reader.readLine()) != null) {
            String[] values = line.trim().split("\\s+");

            if (values.length != numCols) {
                throw new IOException("El número de columnas en una o más filas no coincide");
            }

            for (int col = 0; col < numCols; col++) {
                try {
                    matrix[row][col] = Double.parseDouble(values[col]);
                } catch (NumberFormatException e) {
                    throw new IOException("Error de formato en los valores de la matriz en la fila " + (row + 1) + ", columna " + (col + 1));
                }
            }
            row++;
        }

        reader.close();
        return matrix;
    }
}

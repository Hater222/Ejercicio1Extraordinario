package main;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeterminanteMatrizTest {

    @Test
    public void testDeterminante() {
        // Matriz de 2x2
        double[][] matrix2x2 = {{1, 2}, {3, 4}};
        double expectedDet2x2 = -2.0;
        double actualDet2x2 = DeterminanteMatriz.determinante(matrix2x2);
        assertEquals(expectedDet2x2, actualDet2x2, 0.0001);

        // Matriz de 3x3
        double[][] matrix3x3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        double expectedDet3x3 = 0.0;
        double actualDet3x3 = DeterminanteMatriz.determinante(matrix3x3);
        assertEquals(expectedDet3x3, actualDet3x3, 0.0001);

        // Matriz de 4x4
        double[][] matrix4x4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        double expectedDet4x4 = 0.0;
        double actualDet4x4 = DeterminanteMatriz.determinante(matrix4x4);
        assertEquals(expectedDet4x4, actualDet4x4, 0.0001);

        // Matriz de 5x5
        double[][] matrix5x5 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        double expectedDet5x5 = 0.0;
        double actualDet5x5 = DeterminanteMatriz.determinante(matrix5x5);
        assertEquals(expectedDet5x5, actualDet5x5, 0.0001);
    }
}


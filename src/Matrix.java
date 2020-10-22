import java.util.Arrays;
import java.util.Objects;

public class Matrix {

    private final double[][] matrix;
    private final int numberOfRows;
    private final int numberOfColumns;


    public Matrix(double[][] matrix, int numberOfRows, int numberOfColumns) {
        this.matrix = matrix;
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix that = (Matrix) o;
        return getNumberOfRows() == that.getNumberOfRows() &&
                getNumberOfColumns() == that.getNumberOfColumns() &&
                Arrays.equals(getMatrix(), that.getMatrix());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getNumberOfRows(), getNumberOfColumns());
        result = 31 * result + Arrays.hashCode(getMatrix());
        return result;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    @Override
    public String toString() {
        return "MatrixPojo{" +
                "matrix=" + Arrays.toString(matrix) +
                ", numberOfRows=" + numberOfRows +
                ", numberOfColumns=" + numberOfColumns +
                '}';
    }
}

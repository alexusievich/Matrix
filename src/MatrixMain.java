public class MatrixMain {

    public static void main(String[] args) {

    MatrixWorkerImpl matrix = new MatrixWorkerImpl();

    double [][] array1 = {{1,2,3,4}, {4,3,2,1},{4,5,7,6},{1,2,3,5}};
    double [][] array2 = {{1,2},{2,1},{1,3},{3,1},{1,5}};
    Matrix matrix2 = new Matrix(array1, 4, 4);
    System.out.println(matrix2.getNumberOfRows());
    System.out.println(matrix2.getNumberOfColumns());
    matrix.print(array1);
    System.out.println(matrix.haveSameDimension(array1, array2));
    matrix.print(matrix.add(array1, array2));
    matrix.print(matrix.subtract(array1, array2));
    System.out.println(matrix.determinant(array1));

    }

}

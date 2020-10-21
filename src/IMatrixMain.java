public class IMatrixMain {

    public static void main(String[] args) {

    IMatrixWorkerImpl a = new IMatrixWorkerImpl();
    double [][] Array1 = {{1,2,3,4}, {4,3,2,1},{4,5,7,6},{1,2,3,5}};
    double [][] Array2 = {{1,2},{2,1},{1,3},{3,1},{1,5}};
    a.print(Array1);
    System.out.println(a.haveSameDimension(Array1, Array2));
    a.print(a.add(Array1, Array2));
    a.print(a.subtract(Array1, Array2));
    System.out.println(a.determinant(Array1));

    }

}

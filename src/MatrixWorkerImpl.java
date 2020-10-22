public class MatrixWorkerImpl implements IMatrixWorker {

    @Override
    public void print(double[][] m) {

        for (double[] doubles : m) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(doubles[j] + " ");
            }
            System.out.println();
        }

    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        return m1.length == m2.length && m1[0].length == m2[0].length;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) {

        double[][] msum = new double[m1.length][m1[0].length];

        if (this.haveSameDimension(m1, m2)) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    msum[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return msum;
        } else {
            throw new ArrayStoreException();
        }

    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) {

        double[][] msub = new double[m1.length][m1[0].length];

        if (this.haveSameDimension(m1, m2)) {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m1[0].length; j++) {
                    msub[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return msub;
        } else {
            throw new ArrayStoreException();
        }
    }

    public boolean checkDimensionForMultiply(double[][] m1, double[][] m2) {
        return m1[0].length == m2.length;
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) {

        double[][] mdim = new double[m1.length][m2[0].length];

        if (!checkDimensionForMultiply(m1, m2)) {
            throw new ArithmeticException();
        } else {
            for (int i = 0; i < m1.length; i++) {
                for (int j = 0; j < m2[0].length; j++) {
                    for (int k = 0; k < m1[0].length; k++) {
                        mdim[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            return mdim;
        }
    }

    public double[][] generateSubArray(double[][] m, int j1) {

        double[][] subm = new double[m.length - 1][];

        for (int i = 0; i < (m.length - 1); i++) {
            subm[i] = new double[m.length - 1];
        }

        for (int i = 1; i < m.length; i++) {
            int j2 = 0;
            for (int j = 0; j < m.length; j++) {
                if (j == j1)
                    continue;
                subm[i - 1][j2] = m[i][j];
                j2++;
            }
        }
        return subm;
    }

    public boolean checkDimensionForDeterminant(double[][] m) {
        return m.length == m[0].length;
    }

    public double determinant(double[][] m) {

        if (checkDimensionForDeterminant(m)) {

            double res;

            if (m.length == 1) res = m[0][0]; //1*1 matrix

            else if (m.length == 2) res = m[0][0] * m[1][1] - m[1][0] * m[0][1]; //2*2 matrix

            else { //N*N matrix
                res = 0;
                for (int j1 = 0; j1 < m.length; j1++) {
                    double[][] subm = generateSubArray(m, j1);
                    res += Math.pow(-1.0, 1.0 + j1 + 1.0) * m[0][j1] * determinant(subm);
                }
            }
            return res;
        } else {
            throw new ArrayStoreException();
        }

    }


}
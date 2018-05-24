import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        /***************************  MATRIX A  ******************************************/
        ArrayList<ArrayList<BigDecimal>> A = new ArrayList<>();
        ArrayList<BigDecimal> aV = new ArrayList<>();
        aV.add(new BigDecimal("0.8"));
        aV.add(new BigDecimal("0.4"));
        aV.add(new BigDecimal("0.3"));
        ArrayList<BigDecimal> Va = new ArrayList<>();
        Va.add(new BigDecimal("3"));
        Va.add(new BigDecimal("15"));
        Va.add(new BigDecimal("30"));
        A.add(aV);
        A.add(Va);
        /***************************  MATRIX B  ******************************************/
        ArrayList<ArrayList<BigDecimal>> B = new ArrayList<>();
        ArrayList<BigDecimal> bV = new ArrayList<>();
        bV.add(new BigDecimal("0.1"));
        bV.add(new BigDecimal("0.5"));
        bV.add(new BigDecimal("0.8"));
        ArrayList<BigDecimal> Vb = new ArrayList<>();
        Vb.add(new BigDecimal("0.9"));
        Vb.add(new BigDecimal("0.5"));
        Vb.add(new BigDecimal("0.1"));
        B.add(bV);
        B.add(Vb);
        /***************************  MATRIX C  ******************************************/
        ArrayList<ArrayList<BigDecimal>> C = new ArrayList<>();
        ArrayList<BigDecimal> cV = new ArrayList<>();
        cV.add(new BigDecimal("0.8"));
        cV.add(new BigDecimal("0.5"));
        cV.add(new BigDecimal("0.3"));
        ArrayList<BigDecimal> Vc = new ArrayList<>();
        Vc.add(new BigDecimal("0.9"));
        Vc.add(new BigDecimal("0.5"));
        Vc.add(new BigDecimal("0.2"));
        C.add(cV);
        C.add(Vc);


/*        System.out.println(notM(A).toString());
        System.out.println(notM(veryM(A)).toString());

        System.out.println(A.get(0).get(0).toString());
        System.out.println(aXb(notM(A), notM(B)).toString());
        System.out.println(aXb(A, B).toString());
        System.out.println(aUb(aXb(A, B), aXb(notM(A), notM(B))).toString());*/
        System.out.println("**********************************************");
        System.out.println(yXa(notM(veryM(A)), aUb(aXb(A, B), aXb(notM(A), notM(B)))).toString());
        System.out.println("**********************************************");

        System.out.println("**********************************************");
        System.out.println(yXa(notM(veryM(A)), aUb(aXb(notM(A), C), aXb(A, notM(C)))).toString());
        System.out.println("**********************************************");


    }

    /***************************  NOT MATRIX  ******************************************/
    public static ArrayList<ArrayList<BigDecimal>> notM(ArrayList<ArrayList<BigDecimal>> matrix) {
        ArrayList<ArrayList<BigDecimal>> matrixNot = new ArrayList<>();
        ArrayList<BigDecimal> tmpMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.get(0).size(); i++) {
            tmpMatrix.add(new BigDecimal("1.0").subtract(matrix.get(0).get(i)));
        }
        matrixNot.add(tmpMatrix);
        matrixNot.add(matrix.get(1));
        return matrixNot;
    }

    /***************************  VERY MATRIX  ******************************************/
    public static ArrayList<ArrayList<BigDecimal>> veryM(ArrayList<ArrayList<BigDecimal>> matrix) {
        ArrayList<ArrayList<BigDecimal>> matrixVery = new ArrayList<>();
        ArrayList<BigDecimal> tmpMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.get(0).size(); i++) {
            tmpMatrix.add((matrix.get(0).get(i)).multiply(matrix.get(0).get(i)));
        }
        matrixVery.add(tmpMatrix);
        matrixVery.add(matrix.get(1));
        return matrixVery;
    }

    /***************************  AxB  ******************************************/
    public static ArrayList<ArrayList<BigDecimal>> aXb(ArrayList<ArrayList<BigDecimal>> matrix1, ArrayList<ArrayList<BigDecimal>> matrix2) {
        ArrayList<ArrayList<BigDecimal>> matrixResult = new ArrayList<>();
        ArrayList<BigDecimal> tmpMatrix = new ArrayList<>();
        for (int i = 0; i < matrix1.get(0).size(); i++) {
            for (int j = 0; j < matrix2.get(0).size(); j++) {
                tmpMatrix.add(matrix1.get(0).get(i).min(matrix2.get(0).get(j)));

            }
        }
        matrixResult.add(tmpMatrix);
        matrixResult.add(matrix2.get(1));
        return matrixResult;
    }

    /***************************  A U B  ******************************************/
    public static ArrayList<ArrayList<BigDecimal>> aUb(ArrayList<ArrayList<BigDecimal>> matrix1, ArrayList<ArrayList<BigDecimal>> matrix2) {
        ArrayList<ArrayList<BigDecimal>> matrixResult = new ArrayList<>();
        ArrayList<BigDecimal> tmpMatrix = new ArrayList<>();
        for (int j = 0; j < matrix2.get(0).size(); j++) {
            tmpMatrix.add(matrix1.get(0).get(j).max(matrix2.get(0).get(j)));

        }
        matrixResult.add(tmpMatrix);
        matrixResult.add(matrix2.get(1));
        return matrixResult;
    }

    /***************************   y = xA  ******************************************/
    public static ArrayList<ArrayList<BigDecimal>> yXa (ArrayList<ArrayList<BigDecimal>> matrix1, ArrayList<ArrayList<BigDecimal>> matrix2) {
        ArrayList<ArrayList<BigDecimal>> matrixResult = new ArrayList<>();
        ArrayList<BigDecimal> tmpMatrix = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmpMatrix.add(   matrix1.get(0).get(2).min(matrix2.get(0).get(i+6))
                    .max((matrix1.get(0).get(0).min(matrix2.get(0).get(i)))
                    .max(matrix1.get(0).get(1).min(matrix2.get(0).get(i+3))) ) );
        }
        matrixResult.add(tmpMatrix);
        matrixResult.add(matrix2.get(1));
        return matrixResult;
    }


}

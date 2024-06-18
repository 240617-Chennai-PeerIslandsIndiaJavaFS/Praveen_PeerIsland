public class twoD_Matrix {
    public static void main(String[] args) {
        int[][] matrix1= {{1,2},{1,2}};
        int[][] matrix2= {{1,2,3},{1,2,3}};

        int rowsA = matrix1.length;
        int colsA = matrix1[0].length;
        int rowsB = matrix2.length;
        int colsB = matrix2[0].length;


        int[][] result= new int[rowsA][colsB];

        if(rowsA != colsB){
            System.out.println("MATRIX NOT VALID");
            return;
        }

        for(int i =0 ;i<rowsA; i++){
            for(int j =0 ;j<rowsA; j++){
                result[i][j] =  matrix1[i][j] + matrix2[i][j];
            }
        }

        for(int i =0 ;i<rowsA; i++){
            for(int j =0 ;j<rowsA; j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }


    }
}

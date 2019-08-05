public class DS2DMatrix {
    public static void main(String[] args){

        //PROBLEM::
        //https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
        int[][] ma = new int [6][6];
        ma[0][0] = -9;
        ma[0][1] = -9;
        ma[0][2] = -9;
        ma[0][3] = 1;
        ma[0][4] = 1;
        ma[0][5] = 1;

        ma[1][0] = 0;
        ma[1][1] = -9;
        ma[1][2] = 0;
        ma[1][3] = 4;
        ma[1][4] = 3;
        ma[1][5] = 2;

        ma[2][0] = -9;
        ma[2][1] = -9;
        ma[2][2] = -9;
        ma[2][3] = 1;
        ma[2][4] = 2;
        ma[2][5] = 3;

        ma[3][0] = 0;
        ma[3][1] = 0;
        ma[3][2] = 8;
        ma[3][3] = 6;
        ma[3][4] = 6;
        ma[3][5] = 0;

        ma[4][0] = 0;
        ma[4][1] = 0;
        ma[4][2] = 0;
        ma[4][3] = -2;
        ma[4][4] = 0;
        ma[4][5] = 0;

        ma[5][0] = 0;
        ma[5][1] = 0;
        ma[5][2] = 1;
        ma[5][3] = 2;
        ma[5][4] = 4;
        ma[5][5] = 0;

        int row = 0, col = 0;
        int sum = 0;
        while(row<4){
            int intenalRow = -1;
            int internalCol = -1;
            int aux = 0;
            for(int l = row; l <= row + 2; l++) {
                intenalRow++;
                for (int c = col; c <= col + 2; c++) {
                    internalCol++;
                    if(shouldBeConsidered(intenalRow, internalCol)){
                        System.out.printf("row: %d, col: %d\n",intenalRow,internalCol);
                        aux += ma[l][c];
                    }
                }
                internalCol = -1;
            }

            if(aux > sum) sum = aux;

            aux = 0;

            if(col == 3) {
                row++;
                col = 0;
                continue;
            }

            col++;
        }
        System.out.println("Sum: "+sum);

//       -9 -9 -9  1 1 1
//        0 -9  0  4 3 2
//       -9 -9 -9  1 2 3
//        0  0  8  6 6 0
//        0  0  0 -2 0 0
//        0  0  1  2 4 0
    }

    private static boolean shouldBeConsidered(int row, int col){
        boolean isWhatWant = true;
        if (row == 1 && col ==0 || row == 1 && col ==2){
            isWhatWant = false;
        }

        return isWhatWant;
    }
}


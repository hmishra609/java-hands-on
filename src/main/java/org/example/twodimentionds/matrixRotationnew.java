package org.example.twodimentionds;

public class matrixRotationnew {

    static void main() {
        int [][] arr= {

                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = arr.length;


        // transpose
        for(int i=0;i< arr.length;i++){

            for(int j=0;j< arr[i].length;j++){
                int temp= arr[i][j];

                arr[i][j]= arr[j][i];

                arr[j][i]= temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j=0; j< n/2; i++){

                int temp= arr[i][j];

                arr[i][j]= arr[i][n-1-j];

                arr[i][n-1-j]= temp;

            }

        }


    }
}

package examples.practice;

public class TwoDimensionalArrays {
    public static void main(String[] args) {
        int rowLen = 3;
        int colLen = 4;
        char[][] arr = new char[rowLen][colLen];
        //arr[0][0] = 'a';

        for(char[] row : arr){
            int col0 = 0;
            int col1 = 1;
            int col2 = 2;
            int col3 = 3;
            row[col0] = 'l';
            row[col1] = 'o';
            row[col2] = 'v';
            row[col3] = 'e';
            System.out.print(row[col0] + " " + row[col1]);
            System.out.print(" " + row[col2] + " " + row[col3] + "\n");
        }
    }
}

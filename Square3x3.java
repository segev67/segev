public class Square3x3
{
    private static final int SIZE = 3;
    private int[][] array;

    public Square3x3()
    {
        array = new int[SIZE][SIZE];

        for (int i=0; i < array.length; i++){
            for (int j=0; j < array[0].length; j++){
                array[i][j] = -1;
            }
        }
    }

    public Square3x3(int[][] array)
    {
        this.array = new int[SIZE][SIZE];

        for (int i=0; i < this.array.length; i++){
            for (int j=0; j < this.array[0].length; j++){
                if (i < array.length && j < array.length){
                    this.array[i][j] = array[i][j];
                }
                else {
                    this.array[i][j] = -1;
                }
            }
        }
    }

    public Square3x3(Square3x3 other)
    {
        this.array = new int[SIZE][SIZE];

        for (int i = 0; i < this.array.length; i++){
            for (int j=0; j < this.array[0].length; j++){
                this.array[i][j] = other.array[i][j];
            }
        }
    }

    public int getCell(int row, int col)
    {
        if (row >= 0 && col >=0 && row < SIZE && col < SIZE){
            return array[row][col];
        }
        //row or col out of the bound  
        return -1;
    }

    public void setXY(int row, int col, int value)
    {
        if (row >= 0 && col >= 0 && row < SIZE && col < SIZE){
            array[row][col] = value;
        }
    }

    public String toString()
    {
        String s = "";
        for (int i=0; i < this.array.length; i++){
            for (int j=0; j < this.array[0].length; j++){
                if (j == (SIZE-1)){
                    s += array[i][j] + "\n";
                }
                else {    
                    s += array[i][j] + "\t";
                }
            }
        }
        return s;
    }

    //Q2

    public boolean allThere()
    {
        for(int k = 1; k < 10; k++){
            if (this.inSquare3x3(k) == false){
                //k is not in the array
                return false;
            }
        }//all the values between 1 and 9 are in the array
        return true;
    }

    private boolean inSquare3x3(int x)
    {
        for (int i = 0; i < this.array.length; i++){
            for (int j = 0; j < this.array[0].length; j++){
                //check if k is in the array
                if (x == array[i][j])
                    return true;
            }
        }
        //x is not in the array
        return false;
    }

    public void whosThereRow(int row, boolean[] values)
    {
        if (row < 0 || row >= SIZE || values.length != 10)
            return;

        for (int j = 0; j < SIZE; j++){
            if (array[row][j] >= 1 && array[row][j] <= 9){
                values[array[row][j]] = true;
            }
        }
    }
}
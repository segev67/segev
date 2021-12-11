public class Sudoku
{
    private static final int SIZE = 3;
    private Square3x3[][] array;

    public Sudoku()
    {      
        array = new Square3x3[SIZE][SIZE];

        for (int i=0; i < array.length; i++){
            for (int j=0; j < array[0].length; j++){
                array[i][j] = new Square3x3(); 
            }
        }

    }

    public Sudoku(Square3x3[][] square3x3array)
    {
        this.array = new Square3x3[SIZE][SIZE];
        for (int i=0; i < array.length; i++){
            for (int j=0; j < array[0].length; j++){
                this.array[i][j] = new Square3x3(square3x3array[i][j]);
            }
        }
    }
    
    public boolean isValid()
    {
        for (int outsideRow = 0; outsideRow < SIZE; outsideRow++){
            for (int insideRow = 0; insideRow < SIZE; insideRow++){
                //if there is an valid row the whole sudoku is invalid
                if (this.isValidRow(outsideRow, insideRow) == false){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(int outsideRow, int insideRow)
    {
        //initilize false values array
        boolean[] val = new boolean[10];
        for (int j = 0; j < SIZE; j++){
            array[outsideRow][j].whosThereRow(insideRow, val);
        }
        return isAllTrue(val);
    }
    
    
    private static boolean isAllTrue(boolean[] val)
    {
        for (int i = 0; i < val.length; i++){
            if (val[i] == false)
                return false;
        }
        return true;
    }
}

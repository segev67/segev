public class Sudoku {

    private static final int SIZE = 3;
    private Square3x3[][] array;

    public Sudoku() {
        array = new Square3x3[SIZE][SIZE];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new Square3x3();
            }
        }
    }

    public Sudoku(Square3x3[][] square3x3array) {
        this.array = new Square3x3[SIZE][SIZE];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                this.array[i][j] = new Square3x3(square3x3array[i][j]);
            }
        }
    }

    public boolean isValid() {
        return checkAllRows() && checkAllCols() && checkAllSquares();
    }

    private boolean checkAllSquares() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!array[i][j].allThere()) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAllRows() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean[] values = new boolean[10];
                for (int x = 0; x < SIZE; x++) {
                    this.array[j][x].whosThereRow(i, values);
                }
                // TODO :: Check boolean array if all true
                if (!checkValues(values)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkAllCols() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                boolean[] values = new boolean[10];
                for (int x = 0; x < SIZE; x++) {
                    this.array[x][j].whosThereCol(i, values);
                }
                // TODO :: Check boolean array if all true
                if (!checkValues(values)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkValues(boolean[] values) {
        for (int i = 1; i < values.length; i++) {
            if (values[i] == false) {
                return false;
            }
        }
        return true;
    }
}

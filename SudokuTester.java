public class SudokuTester
{
    public static void main(String[] args)
    {
        int[][] a1 = {{1,2}};
        int[][] a2 = {{1,2}, {3,4}};
        int[][] a3 = {{1,2,8}, {3,4,6}};
        int[][] a4 = {{1,2,8},{3,6},{9}};
        
        
        Square3x3 square1 = new Square3x3(a1);
        Square3x3 square2 = new Square3x3(a2);
        Square3x3 square3 = new Square3x3(a3);
        Square3x3 square4 = new Square3x3(a4);
        
        System.out.println(square1);
        System.out.println(square2);
        System.out.println(square3);
        System.out.println(square4);
    }
}
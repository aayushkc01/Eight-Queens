public class EightQueens {
    private static final int BOARD_SIZE = 8;
    private static int[] queens = new int[BOARD_SIZE];

    public static void main(String[] args) {
        solveQueensProblem(0);
    }

    public static void solveQueensProblem(int currentColumn) {
        if (currentColumn == BOARD_SIZE) {
            printQueens();
            return;
        }

        for (int row = 0; row < BOARD_SIZE; row++) {
            if (isSafePlace(row, currentColumn)) {
                queens[currentColumn] = row;
                solveQueensProblem(currentColumn + 1);
            }
        }
    }

    public static boolean isSafePlace(int row, int col) {
        for (int prev = 0; prev < col; prev++) {
            int prevRow = queens[prev];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prev - col)) {
                return false;
            }
        }
        return true;
    }

    public static void printQueens() {
        System.out.println("Solution:");
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (queens[col] == row) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

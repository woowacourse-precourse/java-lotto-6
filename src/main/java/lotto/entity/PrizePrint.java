package lotto.entity;

public class PrizePrint {
    public class CalculatorPrize {
        private static final int[] PRIZES = {0, 0, 0, 5000, 50000, 1500000, 30000000, 2000000000};

        public static int calculatePrize(int winCount) {
            if (winCount >= 0 && winCount < PRIZES.length) {
                return PRIZES[winCount];
            }
            return 0;
        }
    }
}

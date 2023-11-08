package lotto;

public class LottoResult {
    private static final int[] PRICE = {5000, 50000, 1500000, 2000000000, 30000000};

    private int[] lottoWinningCounts;

    public LottoResult() {
        lottoWinningCounts = new int[5];
    }

    public void calculate(int cnt, boolean correct) {
        if (!correct) {
            if (cnt <= 5 || cnt == 6) {
                this.lottoWinningCounts[cnt - 3]++;
            }
            return;
        }
        if (cnt == 5) {
            this.lottoWinningCounts[4]++;
        }
    }

    public int[] getLottoResult() {
        return this.lottoWinningCounts;
    }

    public int total() {
        int total = 0;
        for (int i = 0; i < lottoWinningCounts.length; i++) {
            total += (PRICE[i] * lottoWinningCounts[i]);
        }
        return total;
    }
}

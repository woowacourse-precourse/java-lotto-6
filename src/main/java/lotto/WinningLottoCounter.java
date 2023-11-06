package lotto;

public class WinningLottoCounter {

    private final int[] winningLottoCounter;
    private final int[] prizeMoney = {30000000, 0, 0, 5000, 50000, 1500000, 2000000000};

    public WinningLottoCounter() {
        this.winningLottoCounter = new int[7];
    }

    public void increment(int index) {
        winningLottoCounter[index]++;
    }

    public int getCount(int index) {
        return winningLottoCounter[index];
    }

    public long getTotalPrizeMoney() {
        long total = 0;
        for (int i = 0; i < 7; i++) {
            total += ((long) winningLottoCounter[i] * prizeMoney[i]);
        }
        return total;
    }
}

package lotto.domain;


public class LottoResult {

    private int[] winningCounts;

    public LottoResult() {
        winningCounts = new int[5];
    }

    public void incrementCount(int rank) {
        if (rank >= 1 && rank <= 5) {
            winningCounts[rank - 1]++;
        }
    }

    public int getCount(int rank) {
        if (rank >= 1 && rank <= 5) {
            return winningCounts[rank - 1];
        }
        return 0;
    }
}
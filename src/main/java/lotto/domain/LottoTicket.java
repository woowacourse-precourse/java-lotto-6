package lotto.domain;

public class LottoTicket {
    private int[] Numbers;
    private int winningResult;

    public int[] getNumbers() {
        return Numbers;
    }

    public void setNumbers(int[] numbers) {
        Numbers = numbers;
    }

    public int getWinningResult() {
        return winningResult;
    }

    public void setWinningResult(int winningResult) {
        this.winningResult = winningResult;
    }
}

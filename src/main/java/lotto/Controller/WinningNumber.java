package lotto.Controller;

public class WinningNumber {
    private int winningNumber;
    private int sequence;

    public WinningNumber(int number, int sequence) {
        this.winningNumber = number;
        this.sequence = sequence;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public int getSequence() {
        return sequence;
    }
}

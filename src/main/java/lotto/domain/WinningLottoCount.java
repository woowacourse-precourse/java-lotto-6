package lotto.domain;

public class WinningLottoCount {
    private int winningThree;
    private int winningFour;
    private int winningFive;
    private int winningSix;
    private int winningBonus;

    public int getWinningThree() {
        return winningThree;
    }

    public int getWinningFour() {
        return winningFour;
    }

    public int getWinningFive() {
        return winningFive;
    }

    public int getWinningSix() {
        return winningSix;
    }

    public int getWinningBonus() {
        return winningBonus;
    }

    public void addWinningThree() {
        this.winningThree += 1;
    }

    public void addWinningFour() {
        this.winningFour += 1;
    }

    public void addWinningFive() {
        this.winningFive += 1;
    }

    public void addWinningSix() {
        this.winningSix += 1;
    }

    public void addWinningBonus() {
        this.winningBonus += 1;
    }
}

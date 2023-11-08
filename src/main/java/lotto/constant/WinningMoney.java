package lotto.constant;

public enum WinningMoney {
    LOTTO_WIN(2000000000),
    SECOND_WIN(30000000),
    THIRD_WIN(1500000),
    FOURTH_WIN(50000),
    FIFTH_WIN(5000);
    private final int winningMoney;

    WinningMoney(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}

package lotto;

public enum LottoRank {

    five("3개 일치", 5000),
    four("4개 일치", 50000),
    three("5개 일치", 1500000),
    two("5개 일치, 보너스 볼 일치", 30000000),
    one("6개 일치", 2000000000);

    private final String winningNumber;
    private final int winningPrice;

    LottoRank(String winningNumber, int winningPrice) {
        this.winningNumber = winningNumber;
        this.winningPrice = winningPrice;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public String getResult(int numOfResult) {
        return "%s (%,d) - %d개".formatted(winningNumber, winningPrice, numOfResult);
    }
}

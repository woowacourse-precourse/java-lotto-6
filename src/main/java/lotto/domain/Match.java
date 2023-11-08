package lotto.domain;

public enum Match {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000);

    private int numOfMatches;
    private double price;

    Match(int numOfMatches, double price) {
        this.numOfMatches = numOfMatches;
        this.price = price;
    }

    public int getNumOfMatches() {
        return numOfMatches;
    }

    public double getPrice() {
        return price;
    }
}

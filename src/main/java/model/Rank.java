package model;

public enum Rank {
    PLACE_FIFTH(3, 5000),
    PLACE_FOURTH(4, 50000),
    PLACE_THIRD(5, 1500000),
    PLACE_SECOND(7, 30000000),
    PLACE_FIRST(6, 2000000000);
    private final int rank;
    private final int price;

    Rank(int rank, int price) {
        this.rank = rank;
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public int getPrice() {
        return price;
    }

}

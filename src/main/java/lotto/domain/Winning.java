package lotto.domain;

public enum Winning {
    FIND(1, 0),
    THIRD(3, 5000)
    ;

    private final int label;
    private final int price;

    Winning(int label, int price) {
        this.label = label;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
}

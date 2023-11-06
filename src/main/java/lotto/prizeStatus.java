package lotto;

public enum prizeStatus {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), FIVEBONUS(5, 30000000), SIX(6, 2000000000);

    private int num;
    private int price;

    prizeStatus(int num, int price) {
        this.num = num;
        this.price = price;
    }

    public int getNum() {
        return this.num;
    }

    public int getPrice() {
        return this.price;
    }
}

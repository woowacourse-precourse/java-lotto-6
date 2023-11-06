package lotto;

public enum prizeStatus {
    THREE(3, 5000, 3), FOUR(4, 50000, 4), FIVE(5, 1500000, 5),
    FIVEBONUS(5, 30000000, 105), SIX(6, 2000000000, 6);

    private int num;
    private int price;
    private int prizeNum;

    prizeStatus(int num, int price, int prizeNum) {
        this.num = num;
        this.price = price;
        this.prizeNum = prizeNum;
    }

    public int getNum() {
        return this.num;
    }

    public int getPrice() {
        return this.price;
    }

    public int getPrizeNum() {return this.prizeNum;}
}



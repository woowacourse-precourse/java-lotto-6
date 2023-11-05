package lotto;

public enum prizeStatus {
    THREE(3, "5,000원"), FOUR(4, "50,000원"), FIVE(5, "1,500,000원"), FIVEBONUS(5, "30,000,000원"), SIX(6, "2,000,000,000원");

    private int num;
    private String price;
    prizeStatus(int num, String price) {
        this.num = num;
        this.price = price;
    }

    public int getNum() {
        return this.num;
    }

    public String getPrice() {
        return this.price;
    }
}

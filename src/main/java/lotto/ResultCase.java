package lotto;

public enum ResultCase {
    SIX_CORRECTNESS( 6,2000000000, "6개 일치 (2,000,000,000원) - "),
    FIVE_AND_BONUS_CORRECTNESS(6,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE_CORRECTNESS( 5,1500000, "5개 일치 (1,500,000원) - "),
    FOUR_CORRECTNESS( 4,50000, "4개 일치 (50,000원) - "),
    THREE_CORRECTNESS( 3,5000, "3개 일치 (5,000원) - ");

    private int correctness;
    private int price;
    private String inform;

    ResultCase(int correctness, int price, String inform) {
        this.correctness = correctness;
        this.price = price;
        this.inform = inform;
    }

    public int getCorrectness() {
        return this.correctness;
    }

    public int getPrice() {
        return this.price;
    }

    public String getInform() {
        return this.inform;
    }
}

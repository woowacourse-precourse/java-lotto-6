package lotto;

public enum ResultCase {
    SIX_CORRECTNESS(1, 6,2000000000, "6개 일치 (2,000,000,000원) - "),
    FIVE_AND_BONUS_CORRECTNESS(2, 6,30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIVE_CORRECTNESS(3, 5,1500000, "5개 일치 (1,500,000원) - "),
    FOUR_CORRECTNESS(4, 4,50000, "4개 일치 (50,000원) - "),
    THREE_CORRECTNESS(5, 3,5000, "3개 일치 (5,000원) - ");

    private int rank;
    private int correctness;
    private int price;
    private String inform;

    ResultCase(int rank, int correctness, int price, String inform) {
        this.rank = rank;
        this.correctness = correctness;
        this.price = price;
        this.inform = inform;
    }

    public int getRank() {
        return this.rank;
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

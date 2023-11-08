package util;

public enum ConstOfLottoResult {
    FIFTH_RANK(5, "3개 일치 (5,000원) - ",5000),
    FORTH_RANK(4, "4개 일치 (50,000원) - ",50000),
    THIRD_RANK(3, "5개 일치 (1,500,000원) - ",1500000),
    SECOND_RANK(2,"5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    FIRST_RANK(1,"6개 일치 (2,000,000,000원) - ",2000000000);

    private final int rank;
    private final String messageOFRank;
    private final int price;

    ConstOfLottoResult(int rank, String messageOFRank, int price) {
        this.rank = rank;
        this. messageOFRank = messageOFRank;
        this.price = price;
    }

    public int getRank() {
        return rank;
    }

    public String getMessageOFRank() {
        return messageOFRank;
    }

    public int getPrice() {
        return price;
    }
}

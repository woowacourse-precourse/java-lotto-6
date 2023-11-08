package lotto;

public enum WinnerPrice {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "), // 1등
    SECOND(7, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "), // 2등
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "), // 3등
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "), // 4등
    FIFTH(3, 5_000, "3개 일치 (5,000원) - "), // 5등
    NONE(0, 0, "");

    private int equalCount;
    private long priceAmount;
    private String printPrice;

    WinnerPrice(int equalCount, long priceAmount, String printPrice) {
        this.equalCount = equalCount;
        this.priceAmount = priceAmount;
        this.printPrice = printPrice;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public long getPriceAmount() {
        return priceAmount;
    }

    public String getPrintPrice() {
        return printPrice;
    }
}

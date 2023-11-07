package lotto.winningmanager;

public enum WinningRank {
    RANK_1ST(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    RANK_2ND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    RANK_3RD(1_500_000, "5개 일치 (1,500,000원)"),
    RANK_4TH(50_000, "4개 일치 (50,000원)"),
    RANK_5TH(5_000, "3개 일치 (5,000원)");

    private final int price;
    private final String message;

    private WinningRank(int price, String message) {
        this.price = price;
        this.message = message;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}

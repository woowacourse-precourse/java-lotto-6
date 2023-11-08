package lotto.constant;

public enum LottoResult {
    FIFTH_RANK(1, 3, 5_000, "3개 일치 (5,000원) - "),
    FOURTH_RANK(2, 4, 50_000, "4개 일치 (50,000원) - "),
    THIRD_RANK(3, 5, 1_500_000, "5개 일치 (1,500,000원) - "),
    SECOND_RANK(4, 5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_RANK(5, 6, 2_000_000_000, "6개 일치 (2,000,000,000원) - ");

    private final int index;
    private final int rank;
    private final int money;
    private final String message;

    LottoResult(int index, int rank, int money, String message) {
        this.index = index;
        this.rank = rank;
        this.money = money;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public int getRank() {
        return rank;
    }

    public int getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }

    public static LottoResult fromIndex(int index) {
        for (LottoResult result : values()) {
            if (result.getIndex() == index) {
                return result;
            }
        }
        throw new IllegalArgumentException("Invalid index: " + index);
    }
}


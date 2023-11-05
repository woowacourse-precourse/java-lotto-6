package lotto.domain;

public enum LottoResult {
    FIRST("6개 일치 (2,000,000,000원)", 2_000_000_000, 6, 0),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000, 5, 1),
    THIRD("5개 일치 (1,500,000원)", 1_500_000, 5, 0),
    FORTH("4개 일치 (50,000원)", 50_000, 4, 0),
    FIFTH("3개 일치 (5,000원)", 5_000, 3, 0),
    ;

    private final String message;
    private final int price;
    private final int lotto_count;
    private final int bonus_number_count;

    LottoResult(String message, int price, int lottoCount, int bonusNumberCount) {
        this.message = message;
        this.price = price;
        lotto_count = lottoCount;
        bonus_number_count = bonusNumberCount;
    }

    public String getMessage() {
        return message;
    }

    public int getPrice() {
        return price;
    }

    public int getLotto_count() {
        return lotto_count;
    }

    public int getBonus_number_count() {
        return bonus_number_count;
    }
}

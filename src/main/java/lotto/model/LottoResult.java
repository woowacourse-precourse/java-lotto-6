package lotto.model;

public enum LottoResult {
    FIRST_PLACE(6, false, "6개 일치", 2_000_000_000),
    SECOND_PLACE(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_PLACE(5, false, "5개 일치", 30_000_000),
    FOURTH_PLACE(4, false, "4개 일치", 50_000),
    FIFTH_PLACE(3, false, "3개 일치", 5_000),
    NO_PRIZE(0, false, "꽝", 0);

    private final Integer sameNumbers;
    private final Boolean mustCheckBonus;
    private final String result;
    private final Integer prize;

    LottoResult(Integer sameNumbers, Boolean mustCheckBonus, String result, Integer prize) {
        this.sameNumbers = sameNumbers;
        this.mustCheckBonus = mustCheckBonus;
        this.result = result;
        this.prize = prize;
    }

    public Long getSameNumbers() {
        return Long.valueOf(sameNumbers);
    }

    public Boolean mustCheckBonus() {
        return mustCheckBonus;
    }

    public String getResult() {
        return result;
    }

    public Integer getPrize() {
        return prize;
    }
}

package lotto.model;

public enum LottoRank {
    // 주의: LottoComparator가 LottoRank에 의존하기 때문에,
    // 열거형 원소 순서가 변경되면 예측하지 못한 결과를 낼 수 있습니다.
    FIRST_PLACE(6, false, "6개 일치", 2_000_000_000),
    SECOND_PLACE(5, true, "5개 일치, 보너스 볼 일치", 30_000_000),
    THIRD_PLACE(5, false, "5개 일치", 1_500_000),
    FOURTH_PLACE(4, false, "4개 일치", 50_000),
    FIFTH_PLACE(3, false, "3개 일치", 5_000),
    NO_PRIZE(0, false, "꽝", 0);

    private final Integer sameNumbers;
    private final Boolean mustCheckBonus;
    private final String result;
    private final Integer prize;

    LottoRank(Integer sameNumbers, Boolean mustCheckBonus, String result, Integer prize) {
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

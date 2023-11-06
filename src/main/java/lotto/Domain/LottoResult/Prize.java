package lotto.Domain.LottoResult;

public enum Prize {
    FIRST_PRIZE(0, 2000000000, 6),
    SECOND_PRIZE(0, 30000000, 5),
    THIRD_PRIZE(0, 1500000, 5),
    FOURTH_PRIZE(0, 50000, 4),
    FIFTH_PRIZE(0, 5000, 3);

    private Integer count;
    private final Integer award;
    private final Integer numberCount;

    Prize(Integer count, Integer award, Integer numberCount) {
        this.count = count;
        this.award = award;
        this.numberCount = numberCount;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getNumberCount() {
        return numberCount;
    }

    public void addCount() {
        this.count+=1;
    }

    public Integer getAward() {
        return award;
    }
}

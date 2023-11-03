package lotto.Domain.LottoResult;

public enum Prize {
    FIRST_PRIZE(0, 2000000000),
    SECOND_PRIZE(0, 30000000),
    THIRD_PRIZE(0, 1500000),
    FOURTH_PRIZE(0, 50000),
    FIFTH_PRIZE(0, 5000);

    private Integer count;
    private final Integer award;

    Prize(Integer count, Integer award) {
        this.count = count;
        this.award = award;
    }

    public Integer getCount() {
        return count;
    }

    public void addCount() {
        this.count+=1;
    }

    public Integer getAward() {
        return award;
    }
}

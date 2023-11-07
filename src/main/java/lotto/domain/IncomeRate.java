package lotto.domain;

public class IncomeRate {

    private final float percentageIncomeRate;

    public IncomeRate(int used, int income) {
        income *= 10000;
        int multipliedIncomeRate = income / used;
        percentageIncomeRate = ((float) multipliedIncomeRate) / 100;
    }

    public float getPercentageIncomeRate() {
        return percentageIncomeRate;
    }

}

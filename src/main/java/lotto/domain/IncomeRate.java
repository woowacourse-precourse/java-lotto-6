package lotto.domain;

public class IncomeRate {

    private final float incomeRate;

    public IncomeRate(int used, int income) {
        income *= 10000;
        int multipliedIncomeRate = income / used;
        incomeRate = ((float) multipliedIncomeRate) / 100;
    }

    public float getIncomeRate() {
        return incomeRate;
    }

}

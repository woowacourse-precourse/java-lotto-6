package lotto.domain.service;

import lotto.domain.service.Money;

public class KoreanMoneyService implements Money {
    private Integer money;
    public static int unit = 1000;

    public KoreanMoneyService() {

    }

    public KoreanMoneyService(Integer moneyAmount) {
        this.money = moneyAmount;
    }

    @Override
    public int getTicketAmount(int givenMoney) {
        return givenMoney / unit;
    }

    @Override
    public void checkMoney(int givenMoney) {
        if (givenMoney % unit != 0) {
            throw new IllegalArgumentException("[ERROR]" + givenMoney);
        }
    }

    @Override
    public int saveMoney(int givenMoney) {
        this.money = givenMoney;
        return givenMoney;
    }

    @Override
    public double countPrize(int totalPrize) {
        return (totalPrize) / (double) money * 100;
    }

}

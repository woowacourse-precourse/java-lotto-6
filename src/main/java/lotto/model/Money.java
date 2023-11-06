package lotto.model;

public class Money {
    private final Integer money;
    public static int unit  = 1000;
    public Money(Integer moneyAmount) {
        this.money = moneyAmount;
    }

    public static int getTicketAmount(int givenMoney) {
        return givenMoney/unit;
    }

    public static void checkMoney(int givenMoney) {
        if(givenMoney % unit != 0 ) {
            throw new IllegalArgumentException("[ERROR]" + givenMoney);
        }
    }

    public double countPrize(int totalPrize) {
        return (totalPrize) / (double) money * 100;
    }
}

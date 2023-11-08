package lotto.domain;

import lotto.util.LottoMachine;

public class Money {
    private static final int MULTIPLE_VAL = 100;

    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public Tickets createTicket() {
        LottoMachine machine = new LottoMachine();
        return machine.generateTickets(money);
    }

    public double calcRateOfReturn(long sumOfPrize) {
        return (double) sumOfPrize / money * MULTIPLE_VAL;
    }
}

package lotto.domain;

import lotto.utils.GameRules;

public class TicketMachine {
    private Money money;

    private TicketMachine(Money money) {
        this.money = money;
    }

    public static TicketMachine from(Money money) {
        return new TicketMachine(money);
    }

    public int getTicket(Money money) {
        int ticket = money.getMoney() / GameRules.MINIMUN_UNIT.getValue();
        return ticket;
    }
}

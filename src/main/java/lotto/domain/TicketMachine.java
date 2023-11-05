package lotto.domain;

import lotto.utils.GameRules;

public class TicketMachine {

    private TicketMachine() { }

    public static int getTicket(Money money) {
        return money.getMoney() / GameRules.MINIMUN_UNIT.getValue();
    }
}

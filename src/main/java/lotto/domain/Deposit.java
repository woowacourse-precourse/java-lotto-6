package lotto.domain;

import lotto.config.Constant;

public class Deposit {

    private final int deposit;

    public Deposit(int deposit) {
        if (deposit % Constant.TICKET_PRICE != 0) {
            throw new IllegalArgumentException(Constant.DEPOSIT_UNIT_EXCEPTION);
        }
        this.deposit = deposit;
    }

    public int getDeposit() {
        return deposit;
    }

    public int getLottoTicketsCount() {
        return deposit / Constant.TICKET_PRICE;
    }
}

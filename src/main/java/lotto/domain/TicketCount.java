package lotto.domain;

import static lotto.utils.Constants.ERROR_PREFIX;

public class TicketCount {
    private final int ticketCount;
    private final String INCORRECT_AMOUNT_UNIT = ERROR_PREFIX + "입력한 금액은 1000원 단위가 아닙니다.";

    public TicketCount(int purchaseMoney) {
        validateMoney(purchaseMoney);
        this.ticketCount = purchaseMoney / 1000;
    }

    public int getTicketCount() {
        return this.ticketCount;
    }

    private void validateMoney(int purchaseMoney) throws IllegalArgumentException {
        if (purchaseMoney % 1000 != 0) {
            System.out.println(INCORRECT_AMOUNT_UNIT);
            throw new IllegalArgumentException();
        }
    }
}

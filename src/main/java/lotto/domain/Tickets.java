package lotto.domain;

import lotto.utils.StringUtils;

public class Tickets {

    private static final int PRICE_OF_TICKET = 1000;

    private int numberOfTickets;

    public Tickets(String input) {
        int payment = validate(input);
        numberOfTickets = payment / PRICE_OF_TICKET;
    }

    private int validate(String input) {
        int payment = StringUtils.stringToNumber(input);

        if (isInvalidPayment(payment)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }

        return payment;
    }

    private boolean isInvalidPayment(int payment) {
        return payment < 0 || payment % PRICE_OF_TICKET != 0;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}
package lotto.model;

import static lotto.util.LottoInformation.LOTTO_PRICE;

public class LottoMachine {
    private final int numberOfTickets;

    public LottoMachine(int payment) {
        this.numberOfTickets = calculateNumberOfTickets(payment);
    }

    private int calculateNumberOfTickets(int payment) {
        return payment / LOTTO_PRICE;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }
}

package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.utils.RandomNumberGenerator;

public class Purchase {
    private static final int UNIT = 1000;
    private final Lottos lottos;

    public Purchase(int payAmount) {
        validate(payAmount);

        this.lottos = new Lottos();
        int lottoTicketCount = payAmount / UNIT;
        generateLottoTickets(lottoTicketCount);
    }


    private void validate(int payAmount) {
        checkInUnit(payAmount);
        checkNonNegative(payAmount);
    }

    private void checkInUnit(int payAmount) {
        if (payAmount % UNIT > 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_IN_UNIT);
        }
    }

    private void checkNonNegative(int payAmount) {
        if (payAmount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_AMOUNT_NOT_POSITIVE_NUMBER);
        }
    }

    private void generateLottoTickets(int lottoTicketCount) {
        while (lottoTicketCount > 0) {
            this.lottos.add(RandomNumberGenerator.pickUniqueNumbers());
            lottoTicketCount--;
        }
    }

    public Lottos getPurchasedLottos() {
        return lottos;
    }
}

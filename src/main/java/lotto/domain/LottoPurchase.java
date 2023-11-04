package lotto.domain;

import lotto.enums.ErrorMessages;

public class LottoPurchase {
    private final int amount;

    public LottoPurchase(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public LottoPurchase(String amount) {
        int parsedAmount = stringToInt(amount);
        validateAmount(parsedAmount);
        this.amount = parsedAmount;
    }

    public LottoTickets generateLottoTickets () {
        return new LottoTickets(getNumberOfTickets());
    }

    public int getAmount() {
        return amount;
    }

    public int getNumberOfTickets() {
        return amount / 1000;
    }

    private int stringToInt(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE.getMessage());
        }
    }

    private void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_POSITIVE_INPUT_MESSAGE.getMessage());
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessages.NON_THOUSAND_INPUT_MESSAGE.getMessage());
        }
    }
}

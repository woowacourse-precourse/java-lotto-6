package lotto.domain;

import lotto.view.OutputView;

import static lotto.domain.exception.LottoExceptionList.*;

public class Player {
    private static final int LOTTO_PRICE = 1000;
    private int amountPurchase;
    private int ticketCount;


    public Player(String amountPurchase) {
        validatePurchaseAmount(amountPurchase);
        ticketCount = issueTickets(this.amountPurchase);
    }

    public int getAmountPurchase() {
        return amountPurchase;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private void validatePurchaseAmount(String number) {
        validateNumberPure(number);
        amountPurchase = convertToInt(number);
        validateNumberPositive(amountPurchase);
        validateNumberDivisible(amountPurchase);
    }

    private int issueTickets(int amount) {
        ticketCount = amount / LOTTO_PRICE;
        OutputView.printLottoCount(ticketCount);
        return ticketCount;
    }

    private void validateNumberPure(String number) {
        char temp;
        for (int i = 0; i < number.length(); i++) {
            temp = number.charAt(i);
            if (!Character.isDigit(temp)) {
                throw new IllegalArgumentException(NUMBERS_NOT_PURE_ERROR.getMessage());
            }
        }
    }

    private void validateNumberPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NUMBERS_NOT_POSITIVE_ERROR.getMessage());
        }
    }

    private void validateNumberDivisible(int number) {
        if (number % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(NUMBERS_NOT_DIVIDED_ERROR.getMessage());
        }
    }

    private int convertToInt(String number) {
        return Integer.parseInt(number);
    }
}

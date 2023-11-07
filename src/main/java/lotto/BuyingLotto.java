package lotto;

import java.util.regex.Pattern;

public class BuyingLotto {
    private final long ticketNumber;

    public BuyingLotto(String InputBuyingPrice) {
        validateInputPrice(InputBuyingPrice);
        this.ticketNumber = calculateTicketNumber(Long.parseLong(buyingPrice), LOTTO_PRICE);
    }

    public Long getTicketNumber() {
        return this.ticketNumber;
    }

    private long calculateTicketNumber(long buyingPrice, long unitPrice) {
        validate(buyingPrice, unitPrice);
        return buyingPrice / unitPrice;
    }

    private void validate(long buyingPrice, long unitPrice) {
        validatePlusSign(unitPrice);
        validatePlusSign(buyingPrice);
        validateDivision(buyingPrice, unitPrice);
    }

    private void validateInputPrice(String inputPrice) {
        if (inputPrice.isEmpty() || inputPrice.equals(LINE_SEPARATION)) {
            throw new IllegalArgumentException();
        }
        if (inputPrice.contains(BLANK)) {
            throw new IllegalArgumentException();
        }
        if (!Pattern.matches("^[0-9]+$", inputPrice)) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePlusSign(long number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDivision(long number, long unitNumber) {
        if (number % unitNumber != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}

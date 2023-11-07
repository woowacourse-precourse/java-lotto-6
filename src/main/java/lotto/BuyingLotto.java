package lotto;

import java.util.regex.Pattern;

public class BuyingLotto {
    private final long buyingPrice;
    private final long ticketNumber;

    public BuyingLotto(String InputBuyingPrice) {
        validateInputPrice(InputBuyingPrice);
        this.buyingPrice = inputToNumber(InputBuyingPrice);
        this.ticketNumber = calculateTicketNumber(LOTTO_PRICE);
    }

    public long getBuyingPrice() {
        return this.buyingPrice;
    }
    public long getTicketNumber() {
        return this.ticketNumber;
    }

    private long inputToNumber(String inputPrice) {
        long buyingPrice = Long.parseLong(inputPrice);
        validatePlusSign(buyingPrice);
        validateDivision(buyingPrice, LOTTO_PRICE);
        return buyingPrice;
    }

    private long calculateTicketNumber(long ticketPrice) {
        return buyingPrice / ticketPrice;
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

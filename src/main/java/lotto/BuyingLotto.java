package lotto;

import java.util.regex.Pattern;

public class BuyingLotto {
    private final long buyingPrice;
    private final long ticketNumber;

    public BuyingLotto(String InputBuyingPrice) {
        validateInputPrice(InputBuyingPrice);
        this.buyingPrice = inputToNumber(InputBuyingPrice);
        this.ticketNumber = calculateTicketNumber(NumberConstants.LOTTO_PRICE);
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
        validateDivision(buyingPrice, NumberConstants.LOTTO_PRICE);
        return buyingPrice;
    }

    private long calculateTicketNumber(long ticketPrice) {
        return buyingPrice / ticketPrice;
    }

    private void validateInputPrice(String inputPrice) {
        if (inputPrice.isEmpty()) {
            throw new IllegalArgumentException(Error.EMPTY_INPUT.getMessage());
        }
        if (inputPrice.contains(StringConstants.BLANK)) {
            throw new IllegalArgumentException(Error.CONTAINS_BLANK.getMessage());
        }
        if (!Pattern.matches(StringConstants.REG_NUMBER_STRING, inputPrice)) {
            throw new IllegalArgumentException(Error.CONTAINS_NOT_NUMBER.getMessage());
        }
    }

    private void validatePlusSign(long number) {
        if (number <= NumberConstants.ZERO) {
            throw new IllegalArgumentException(Error.NOT_PLUS_SIGN.getMessage());
        }
    }

    private void validateDivision(long number, long unitNumber) {
        if (number % unitNumber != NumberConstants.ZERO) {
            throw new IllegalArgumentException(Error.NOT_PLUS_SIGN.getMessage());
        }
    }
}

package lotto;

public class BuyingLotto {
    private final long ticketNumber;

    public BuyingLotto(long buyingPrice) {
        this.ticketNumber = calculateTicketNumber(buyingPrice, LOTTO_PRICE);
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

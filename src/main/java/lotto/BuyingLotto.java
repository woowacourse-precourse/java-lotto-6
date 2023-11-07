package lotto;

public class BuyingLotto {
    private final long ticketNumber;

    public BuyingLotto(long buyingPrice) {
        this.ticketNumber = calculateBuyingCount(buyingPrice, LOTTO_PRICE);
    }

    public Long getTicketNumber() {
        return this.ticketNumber;
    }

    private long calculateBuyingCount(long buyingPrice, long unitPrice) {
        validate(buyingPrice, unitPrice);
        return buyingPrice / unitPrice;
    }

    private void validate(long buyingPrice, long unitPrice) {
        validatePositive(unitPrice);
        validatePositive(buyingPrice);
        validateUnit(buyingPrice, unitPrice);
    }

    private void validatePositive(long number) {
        if (number <= ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateUnit(long number, long unitNumber) {
        if (number % unitNumber != ZERO) {
            throw new IllegalArgumentException();
        }
    }
}

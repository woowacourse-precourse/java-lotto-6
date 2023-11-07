package lotto.model;

public class Price {
    private final int price;
    private int ticket;

    public Price(String price) {
        validate(price);
        this.price = Integer.parseInt(price);
    }

    private void validate(String price) {
        ticket = PriceValidator.validate(price);
    }

    public int getLottoTicket() {
        return ticket;
    }

    public int getPrice() {
        return price;
    }

}

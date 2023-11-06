package lotto.model.domain;

public class Purchase {
    private final Integer price;
    private final Integer ticketCount;

    public Purchase(int price, int ticketCount) {
        this.price = price;
        this.ticketCount = ticketCount;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }

    public Integer getPrice() {
        return price;
    }
}

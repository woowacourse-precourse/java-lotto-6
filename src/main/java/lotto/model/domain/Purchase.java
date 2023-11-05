package lotto.model.domain;

public class Purchase {
    private final int price;
    private final int ticketCount;

    public Purchase(int price) {
        this.price = price;
        //TODO: price 유효성 체크하기
        this.ticketCount = price / 1000;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public int getPrice() {
        return price;
    }

}

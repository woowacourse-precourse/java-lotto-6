package lotto.model;


import lotto.exception.NotMultipleOf1000Exception;

public class Purchase {

    private final Integer price;
    private final Integer ticketCount;

    public Purchase(Integer price) {
        validateIsMultipleOf1000(price);
        this.price = price;
        this.ticketCount = price/1000;
    }

    private void validateIsMultipleOf1000(Integer value) {
        if (value % 1000 != 0 || value == 0) {
            throw new NotMultipleOf1000Exception();
        }
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }
}

package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            throw new IllegalArgumentException();
        }
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getTicketCount() {
        return ticketCount;
    }
}

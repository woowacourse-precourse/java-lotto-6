package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public List<List<Integer>> tickets = new ArrayList<>();
    public int price;
    private static final int TICKET_PRICE = 1000;
    public int amount;

    public Ticket(int price) {
        validate(price);
        this.price = price;
        setAmount();
        purchaseTicket();
    }

    private void validate(int price) {
        if (price % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    private void setAmount() {
        this.amount = this.price / TICKET_PRICE;
    }

    private List<Integer> generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void purchaseTicket() {
        for (int i = 0; i < this.amount; i++) {
            this.tickets.add(generateTicket());
        }
    }
}

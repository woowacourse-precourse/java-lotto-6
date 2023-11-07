package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    public List<List<Integer>> tickets = new ArrayList<>();
    public String price;
    private static final int TICKET_PRICE = 1000;
    public final int AMOUNT;

    public Ticket(String price) {
        validate(price);
        this.price = price;
        AMOUNT = Integer.parseInt(this.price) / TICKET_PRICE;
        purchaseTicket();
    }

    private void validate(String price) {
        if (Integer.parseInt(price) % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        this.price = price;
    }

    private List<Integer> generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void purchaseTicket() {
        for (int i = 0; i < this.AMOUNT; i++) {
            this.tickets.add(generateTicket());
        }
    }
}

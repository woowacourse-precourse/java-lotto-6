package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static final int TICKET_PRICE = 1000;
    public List<List<Integer>> tickets = new ArrayList<>();
    public int price;
    public int amount;

    public Customer(String inputPrice) {
        this.price = validate(inputPrice);
        setAmount();
        purchaseTicket();
    }

    private int validate(String inputPrice) {
        int price;
        price = Integer.parseInt(inputPrice);
        if (price % TICKET_PRICE != 0 || price < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
        return price;
    }

    private void setAmount() {
        this.amount = this.price / TICKET_PRICE;
    }

    private List<Integer> generateTicket() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private void purchaseTicket() {
        for (int i = 0; i < this.amount; i++) {
            this.tickets.add(generateTicket());
        }
    }
}

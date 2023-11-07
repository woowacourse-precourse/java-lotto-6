package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public List<List<Integer>> tickets = new ArrayList<>();
    public int inputPrice;
    private static final int TICKET_PRICE = 1000;
    public int amount;

    public Customer(int inputPrice) {
        validate(inputPrice);
        this.inputPrice = inputPrice;
        setAmount();
        purchaseTicket();
    }

    private void validate(int inputPrice) {
        if (inputPrice % TICKET_PRICE != 0) {
            throw new IllegalArgumentException();
        }
        this.inputPrice = inputPrice;
    }

    private void setAmount() {
        this.amount = this.inputPrice / TICKET_PRICE;
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

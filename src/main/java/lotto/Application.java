package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class User {
    public List<List<Integer>> tickets;
    public String price;
    private static final int TICKET_PRICE = 1000;
    public User(String price) {
        validate(price);
        this.price = price;
    }
    private void validate(String price){
        if(Integer.parseInt(price) % TICKET_PRICE != 0){
            throw new IllegalArgumentException();
        }
        this.price = price;
    }
    private List<Integer> generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void purchaseTicket() {
        final int AMOUNT = Integer.parseInt(this.price) / TICKET_PRICE;
        for (int i = 0; i < AMOUNT; i++) {
            this.tickets.add(generateTicket());
        }
    }
}
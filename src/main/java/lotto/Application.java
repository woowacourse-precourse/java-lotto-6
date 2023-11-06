package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

class User {
    public List<List<Integer>> tickets;

    private List<Integer> generateTicket() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    private void purchaseTicket(int price) {
        final int AMOUNT = price / 1000;
        for (int i = 0; i < AMOUNT; i++) {
            this.tickets.add(generateTicket());
        }
    }
}
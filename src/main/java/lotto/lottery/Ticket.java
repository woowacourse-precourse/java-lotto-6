package lotto.lottery;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ticket {
    private static final int TICKET_PRICE = 1000;
    private static int buyingAmount;

    public Ticket(String buyingAmount) {
        this.buyingAmount = Integer.parseInt(buyingAmount);
    }

    public List<List<Integer>> getTicketNumbers() {
        List<List<Integer>> ticketNumbers = new ArrayList<>();
        ticketNumbers = createRandomNumbers(buyTicket());
        return ticketNumbers;
    }

    public int getTicketCount() {
        return buyTicket();
    }

    private int buyTicket() {
        return buyingAmount / TICKET_PRICE;
    }

    private List<List<Integer>> createRandomNumbers(int ticketCount) {
        List<List<Integer>> randomNumbers = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers = numbers.stream()
                    .sorted()
                    .collect(Collectors.toList());
            randomNumbers.add(numbers);
        }
        return randomNumbers;
    }
}

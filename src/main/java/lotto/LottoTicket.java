package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoTicket {
    private final int quantity;
    private List<List<Integer>> tickets;
    private final List<List<Integer>> sortedTickets;

    public LottoTicket(int amount) throws IllegalArgumentException {
        validateAmount(amount);
        this.quantity = amount / 1000;
        this.tickets = new ArrayList<>();
        this.sortedTickets = new ArrayList<>();
        generateTickets();
    }

    public List<List<Integer>> getTickets() {
        return sortedTickets;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validateAmount(int amount) throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입금액은 1000원 단위로 나뉘어야 합니다.");
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public void generateTickets() {
        for (int i = 0; i < quantity; i++) {
            tickets.add(generateLottoNumbers());
        }
    }

    public void sortTickets() {
        sortedTickets.clear(); // Clear the existing sorted_tickets list

        for (List<Integer> ticket : tickets) {
            List<Integer> sortedTicket = new ArrayList<>(ticket); // Create a copy of the ticket
            Collections.sort(sortedTicket); // Sort the copy
            sortedTickets.add(sortedTicket); // Add the sorted copy to the sorted_tickets list
        }
    }

    public void displayTickets() {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
        for (List<Integer> sorted_ticket : sortedTickets) {
            System.out.println(sorted_ticket);
        }
    }
}


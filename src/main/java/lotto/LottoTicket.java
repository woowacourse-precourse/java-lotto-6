package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final int quantity;
    private final List<List<Integer>> tickets;

    public LottoTicket(int amount) throws IllegalArgumentException{
        validateAmount(amount);
        this.quantity = amount / 1000;
        this.tickets = new ArrayList<>();
        generateTickets();
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }

    public int getQuantity() {
        return quantity;
    }

    private void validateAmount(int amount) throws IllegalArgumentException{
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("로또 구입금액은 1000원 단위로 나뉘어야 합니다.");
        }
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    public void generateTickets() {
        for (int i = 0; i < quantity; i++) {
            tickets.add(generateLottoNumbers());
        }
    }

    public void displayTickets() {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
        for (List<Integer> ticket : tickets) {
            Collections.sort(ticket);
            System.out.println(ticket);
        }
    }
}


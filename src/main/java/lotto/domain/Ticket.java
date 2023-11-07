package lotto.domain;

import java.util.List;

public class Ticket {

    private final Lotto lotto;
    public Ticket(List<Integer> numbers) {
        lotto = new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return lotto.getNumbers();
    }
}

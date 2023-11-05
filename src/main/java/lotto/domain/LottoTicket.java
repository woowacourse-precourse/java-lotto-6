package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    private int sameCount;

    private boolean bonus;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
        this.sameCount = 0;
        this.bonus = false;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addSameCount() {
        this.sameCount++;
    }

    public int getSameCount() {
        return sameCount;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void hasBonus() {
        this.bonus = true;
    }

}

package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Computer {

    private final List<Integer> lucky;
    private final int bonus;

    public Computer(List<Integer> lucky, int bonus) {
        this.lucky = lucky;
        this.bonus = bonus;
    }

    public Rank checkWinning(Lotto lotto) {
        Comparator comparator = new Comparator();
        int count = comparator.compare(lotto.getNumbers(), lucky);
        boolean bonus = checkBonus(lotto.getNumbers());
        return Rank.valueOfCount(count, bonus);
    }

    public boolean checkBonus(List<Integer> lotto) {
        return lotto.contains(bonus);
    }

    public void save() {

    }
}

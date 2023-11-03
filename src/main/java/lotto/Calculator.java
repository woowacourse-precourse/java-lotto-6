package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {
    private Map<Prize, Integer> count;
    private final List<Integer> winner;
    private final int bonus;

    public Calculator(List<Integer> winner, int bonus) {
        count = new HashMap<>();
        this.winner=winner;
        this.bonus=bonus;
    }

}

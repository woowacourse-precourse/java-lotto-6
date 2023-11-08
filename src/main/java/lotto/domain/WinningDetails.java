package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.WinningCriteria.FIFTH_PRIZE;
import static lotto.domain.WinningCriteria.FIRST_PRIZE;

public class Winner {

    private Map<Integer, Integer> winners;

    public Winner() {

        winners = new HashMap<>();

        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            winners.put(winningCriteria.getRank(), 0);
        }
    }

    public void increaseCount(int key) {
        validate(key);
        winners.put(key, winners.get(key) + 1);
    }

    public int getWinningCount(int key) {
        validate(key);
        return winners.get(key);
    }

    private void validate(int key) {
        if(key < FIRST_PRIZE.getRank() || key > FIFTH_PRIZE.getRank()){
            throw new IllegalArgumentException();
        }
    }

}

package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.WinningCriteria.FIFTH_PRIZE;
import static lotto.domain.WinningCriteria.FIRST_PRIZE;

public class WinningDetails {

    private Map<Integer, Integer> winningDetails;

    public WinningDetails() {

        winningDetails = new HashMap<>();

        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            winningDetails.put(winningCriteria.getRank(), 0);
        }
    }

    public void increaseCount(int key) {
        validate(key);
        winningDetails.put(key, winningDetails.get(key) + 1);
    }

    public int getWinningCount(int key) {
        validate(key);
        return winningDetails.get(key);
    }

    private void validate(int key) {
        if(key < FIRST_PRIZE.getRank() || key > FIFTH_PRIZE.getRank()){
            throw new IllegalArgumentException();
        }
    }

}

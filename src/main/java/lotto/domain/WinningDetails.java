package lotto.domain;

import lotto.config.WinningCriteria;

import java.util.HashMap;
import java.util.Map;

import static lotto.config.WinningCriteria.FIFTH_PRIZE;
import static lotto.config.WinningCriteria.FIRST_PRIZE;

public class WinningDetails {

    private Map<Integer, Integer> winningDetails;

    public WinningDetails() {

        winningDetails = new HashMap<>();

        for (WinningCriteria winningCriteria : WinningCriteria.values()) {
            winningDetails.put(winningCriteria.getRank(), 0);
        }
    }

    public Map<Integer, Integer> getWinningDetails() {
        return winningDetails;
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

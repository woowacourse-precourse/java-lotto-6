package lotto.domain.model;

import java.util.HashMap;
import java.util.List;

public class WinningNumber {
    private  HashMap<Integer, String> winningNumbers;

    public WinningNumber(HashMap<Integer, String> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public HashMap<Integer, String> getWinningNumbers() {
        return winningNumbers;
    }
}

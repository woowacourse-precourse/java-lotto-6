package lotto;

import java.util.ArrayList;
import java.util.List;

public class DrawResult {

    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public DrawResult(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}

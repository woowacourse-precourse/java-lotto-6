package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    List<Integer> winningNumbers = new ArrayList<>();

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public LottoGame(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

}

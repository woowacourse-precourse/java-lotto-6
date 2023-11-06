package lotto.model.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLottoNumbers;

    public WinningLotto(List<Integer> winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLottoNumbers;
    }
}

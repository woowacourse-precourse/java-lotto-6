package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.constants.Constants;

public class WinningLotto {
    private List<Integer> winninglottos = new ArrayList<>(Constants.MAX_LOTTO_PICK_NUMBER);
    private Integer bonusNumber;

    public WinningLotto(List<Integer> winninglottos, Integer bonusNumber) {
        this.winninglottos = winninglottos;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinninglottos() {
        return winninglottos;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}

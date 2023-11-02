package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Game() {
        lottos = new ArrayList<>();
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    Map<ResultCode, Integer> calculate() {
        return null;
    }

    Double calculateProfitability() {
        return null;
    }
}

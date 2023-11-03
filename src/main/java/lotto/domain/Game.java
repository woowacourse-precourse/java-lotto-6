package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Game implements Constraints {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private Integer bonusNumber;

    public Game() {
        lottos = new ArrayList<>();
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (winningNumbers.stream().anyMatch(value -> value == bonusNumber)
                || bonusNumber < MIN
                || bonusNumber > MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 로도 번호와 중복되지 않는 숫자여야 합니다.");
        }
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

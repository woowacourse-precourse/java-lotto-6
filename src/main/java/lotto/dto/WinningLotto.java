package lotto.dto;

import java.util.List;

public record WinningLotto(Lotto winningLotto, int bonusNumber) {

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLottoNumbers() {
        return winningLotto.getNumbers();
    }

}



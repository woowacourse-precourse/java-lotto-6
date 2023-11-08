package lotto.dto;

import java.util.List;

public record WinningLotto(Lotto winningLotto, int bonusNumber) {

    public List<Integer> winningLottoNumbers() {
        return winningLotto.numbers();
    }

}



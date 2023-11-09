package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public record WinningLotto(Lotto winningLotto, int bonusNumber) {
    public List<Integer> winningLottoNumbers() {
        return winningLotto.getLottoNumbers();
    }

}



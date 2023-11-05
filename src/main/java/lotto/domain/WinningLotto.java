package lotto.domain;

import java.util.List;

public class WinningLotto {
    private  final List<Integer> winningLottoNumbers;
    private  final int bonusNumber;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusNumber = bonusNumber;
    }
}

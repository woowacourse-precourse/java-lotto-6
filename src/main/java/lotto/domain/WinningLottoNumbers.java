package lotto.domain;

import java.util.List;

public class WinningLottoNumbers {
    private final List<LottoNumber> winningLottoNumbers;

    private WinningLottoNumbers(final Lotto winningLottoNumbers) {
        this.winningLottoNumbers = winningLottoNumbers.getLottoNumbers();
    }

    public static WinningLottoNumbers from(final Lotto winningLotto) {
        return new WinningLottoNumbers(winningLotto);
    }

    public List<LottoNumber> getWinningLottoNumbers() {
        return this.winningLottoNumbers;
    }
}
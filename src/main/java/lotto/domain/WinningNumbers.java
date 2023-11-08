package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(LottoNumbers lottoNumbers, BonusNumber bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}

package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final LottoNumbers lottoNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(LottoNumbers lottoNumbers, BonusNumber bonusNumber) {
        validateDuplicated(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicated(LottoNumbers lottoNumbers, BonusNumber bonusNumber) {
        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        int number = bonusNumber.getBonusNumber();

        if (numbers.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER.getValue());
        }
    }
}

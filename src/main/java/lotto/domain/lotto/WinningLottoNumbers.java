package lotto.domain.lotto;

import lotto.dto.LottoNumberMatchDTO;

public class WinningLottoNumbers {

    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(Lotto numbers, LottoNumber bonusNumber) {
        validateNumbersExcludeBonusNumber(numbers, bonusNumber);
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateNumbersExcludeBonusNumber(Lotto numbers, LottoNumber bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoExceptionMessages.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public LottoNumberMatchDTO getMatchDTO(Lotto lotto) {
        int includedNumberCount = numbers.getIncludedNumberCount(lotto);
        boolean isIncludedBonusNumber = lotto.contains(bonusNumber);
        return new LottoNumberMatchDTO(includedNumberCount, isIncludedBonusNumber);
    }

}

package lotto.domain.lotto;

import java.util.List;
import lotto.dto.LottoNumberMatchDTO;

public class WinningLottoNumbers {

    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public WinningLottoNumbers(List<Integer> numbers, int bonusNumber) {
        validateNumbersExcludeBonusNumber(numbers, bonusNumber);
        this.numbers = new Lotto(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateNumbersExcludeBonusNumber(List<Integer> numbers, int bonusNumber) {
        boolean isIncluded = numbers.stream()
                .anyMatch(number -> number == bonusNumber);
        if (isIncluded) {
            throw new IllegalArgumentException(LottoExceptionMessages.DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }

    public LottoNumberMatchDTO getMatchDTO(Lotto lotto) {
        int includedNumberCount = numbers.getIncludedNumberCount(lotto);
        boolean isIncludedBonusNumber = lotto.contains(bonusNumber);
        return new LottoNumberMatchDTO(includedNumberCount, isIncludedBonusNumber);
    }

}

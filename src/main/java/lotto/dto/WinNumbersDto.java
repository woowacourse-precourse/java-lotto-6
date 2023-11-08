package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

import static lotto.util.consts.IntValueConst.END_INCLUSIVE_LOTTO_NUMBER;
import static lotto.util.consts.IntValueConst.START_INCLUSIVE_LOTTO_NUMBER;
import static lotto.util.consts.ErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.util.consts.ErrorMessage.OUT_OF_BONUS_NUMBER_RANGE;

public record WinNumbersDto(List<Integer> winNumbers, int bonusNumber) {

    public WinNumbersDto {
        validate(winNumbers, bonusNumber);
    }

    private void validate(List<Integer> winNumbers, int bonusNumber) {
        new Lotto(winNumbers); // 생성자를 통해 로또 번호 검증
        validateBonusNumberInRange(bonusNumber);
        validateDuplicatedBonusNumber(winNumbers, bonusNumber);
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < START_INCLUSIVE_LOTTO_NUMBER.getValue() ||
                bonusNumber > END_INCLUSIVE_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(OUT_OF_BONUS_NUMBER_RANGE.getMessage());
        }
    }

    private void validateDuplicatedBonusNumber(List<Integer> winNumbers, int bonusNumber) {
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getMessage());
        }
    }
}

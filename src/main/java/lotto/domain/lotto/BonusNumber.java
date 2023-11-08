package lotto.domain.lotto;

import java.util.List;

public class BonusNumber {

    private static final String BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE = "보너스 볼은 로또 번호와 중복될 수 없습니다.";
    private final int bonusNumber;

    public BonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        validateDuplicate(lottoNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        boolean isDuplicated = lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber.equals(bonusNumber));
        if (isDuplicated) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR_MESSAGE);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

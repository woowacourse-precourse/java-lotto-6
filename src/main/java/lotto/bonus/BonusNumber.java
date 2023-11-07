package lotto.bonus;

import lotto.lotto.LottoConstants;
import lotto.lotto.WinningLotto;

public class BonusNumber {

    public static final String NOT_INTEGER_MESSAGE = "보너스 번호는 정수로 입력해야 합니다.";
    public static final String WRONG_RANGER_NUMBER_MESSAGE = "보너스 번호는 1 ~ 45여아 합니다.";
    public static final String DUPLICATE_BONUS_MESSAGE = "보너스 번호가 당첨 번호와 중복되었습니다.";
    private final Integer bonus;

    public BonusNumber(String bonus) {
        Integer bonusNumber = validateInteger(bonus);
        validateNumberRange(bonusNumber);
        this.bonus = bonusNumber;
    }

    public static BonusNumber of(String bonus, WinningLotto winningLotto) {
        BonusNumber bonusNumber = new BonusNumber(bonus);
        validateDuplicateWinningNumber(winningLotto, bonusNumber);
        return bonusNumber;
    }

    private static void validateDuplicateWinningNumber(WinningLotto winningLotto, BonusNumber bonus) {
        if (winningLotto.hasBonusNumber(bonus)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_MESSAGE);
        }
    }

    private void validateNumberRange(Integer bonus) {
        if (bonus < LottoConstants.MIN_LOTTO_NUMBER || bonus > LottoConstants.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(WRONG_RANGER_NUMBER_MESSAGE);
        }
    }

    private Integer validateInteger(String bonus) {
        try {
            return Integer.valueOf(bonus);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }

    public boolean isSameNumber(Integer number) {
        return bonus.equals(number);
    }
}

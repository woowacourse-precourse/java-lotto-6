package lotto.util;

import static lotto.domain.LottoRule.MAXIMUM;
import static lotto.domain.LottoRule.MINIMUM;
import static lotto.domain.LottoRule.PRICE;
import static lotto.domain.LottoRule.SIZE;
import static lotto.util.ErrorMessage.INPUT_BONUS_DUPLICATE;
import static lotto.util.ErrorMessage.INPUT_DUPLICATE_NUMBER;
import static lotto.util.ErrorMessage.INPUT_INVALID_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_IN_RANGE;
import static lotto.util.ErrorMessage.INPUT_NOT_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_THOUSAND_UNIT;
import static lotto.util.ErrorMessage.INPUT_OUT_OF_SIZE;

import java.util.Arrays;
import lotto.domain.Lotto;

public class Validator {

    public void validateMoney(final String money) {
        validateNumber(money);
        validateNumberSize(money);
        validateThousandUnit(Integer.parseInt(money));
    }

    private void validateNumber(final String number) {
        final String REGEX = "[0-9]+";
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(INPUT_NOT_NUMBER.getMessage());
        }
    }

    private void validateNumberSize(final String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception exception) {
            throw new IllegalArgumentException(INPUT_INVALID_NUMBER.getMessage());
        }
    }

    private void validateThousandUnit(final int money) {
        if (money <= 0 || money % PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    public void validateWinningNumber(final String lotto) {
        String[] lottoNumbers = lotto.split(",", -1);
        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Arrays.stream(lottoNumbers).forEach(number -> validateOneNumber(number));
    }

    private void validateOneNumber(final String number) {
        validateNumber(number);
        validateNumberSize(number);
        validateNumberInRange(Integer.parseInt(number));
    }

    private void validateNumberInRange(final int number) {
        if (number < MINIMUM.getValue() || number > MAXIMUM.getValue()) {
            throw new IllegalArgumentException(INPUT_NOT_IN_RANGE.getMessage());
        }
    }

    private void validateSize(String[] lotto) {
        if (lotto.length != SIZE.getValue()) {
            throw new IllegalArgumentException(INPUT_OUT_OF_SIZE.getMessage());
        }
    }

    private void validateDuplicate(String[] lotto) {
        if (Arrays.stream(lotto).distinct().count() != lotto.length) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_NUMBER.getMessage());
        }
    }

    public void validateBonusNumber(Lotto lotto, String number) {
        validateNumber(number);
        validateNumberSize(number);
        validateNumberInRange(Integer.parseInt(number));
        validateBonusDuplicate(lotto, Integer.parseInt(number));
    }

    private void validateBonusDuplicate(Lotto lotto, int number) {
        if (lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(INPUT_BONUS_DUPLICATE.getMessage());
        }
    }
}

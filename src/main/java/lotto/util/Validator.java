package lotto.util;

import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.domain.lotto.LottoRule.PRICE;
import static lotto.domain.lotto.LottoRule.SIZE;
import static lotto.util.ErrorMessage.INPUT_BONUS_DUPLICATE;
import static lotto.util.ErrorMessage.INPUT_DUPLICATE_NUMBER;
import static lotto.util.ErrorMessage.INPUT_INVALID_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_IN_RANGE;
import static lotto.util.ErrorMessage.INPUT_NOT_NUMBER;
import static lotto.util.ErrorMessage.INPUT_NOT_THOUSAND_UNIT;
import static lotto.util.ErrorMessage.INPUT_OUT_OF_SIZE;
import static lotto.util.Utils.stringToInt;

import java.util.Arrays;
import java.util.List;

public class Validator {

    final static String REGEX = "[0-9]+";
    final static String DELIMITER = ",";
    final static int LIMIT = -1;

    public void validateMoney(final String money) {
        validateNumber(money);
        validateNumberSize(money);
        validateThousandUnit(money);
    }

    private void validateNumber(final String number) {
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

    private void validateThousandUnit(final String number) {
        int money = stringToInt(number);

        if (money <= 0 || money % PRICE.getValue() != 0) {
            throw new IllegalArgumentException(INPUT_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    public void validateWinningNumber(final String lotto) {
        String[] lottoNumbers = lotto.split(DELIMITER, LIMIT);

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

    public void validateBonusNumber(List<Integer> lotto, String number) {
        validateNumber(number);
        validateNumberSize(number);
        validateNumberInRange(Integer.parseInt(number));
        validateBonusDuplicate(lotto, Integer.parseInt(number));
    }

    private void validateBonusDuplicate(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException(INPUT_BONUS_DUPLICATE.getMessage());
        }
    }
}

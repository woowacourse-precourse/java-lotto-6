package lotto.util;

import static lotto.domain.lotto.LottoRule.MAXIMUM;
import static lotto.domain.lotto.LottoRule.MINIMUM;
import static lotto.domain.lotto.LottoRule.PRICE;
import static lotto.domain.lotto.LottoRule.SIZE;
import static lotto.util.ErrorMessage.BONUS_DUPLICATE;
import static lotto.util.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.util.ErrorMessage.INVALID_NUMBER;
import static lotto.util.ErrorMessage.NOT_IN_RANGE;
import static lotto.util.ErrorMessage.NOT_NUMBER;
import static lotto.util.ErrorMessage.NOT_THOUSAND_UNIT;
import static lotto.util.ErrorMessage.OUT_OF_SIZE;
import static lotto.util.Utils.stringToInt;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private static final String REGEX = "[0-9]+";
    private static final String DELIMITER = ",";
    private static final int LIMIT = -1;
    private static final int NOTHING = 0;
    private static final int FIT_THOUSAND = 0;

    public static void validateMoney(final String money) {
        validateNumber(money);
        validateNumberSize(money);
        validateThousandUnit(money);
    }

    public static void validateNumber(final String number) {
        if (!number.matches(REGEX)) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    private static void validateNumberSize(final String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception exception) {
            throw new IllegalArgumentException(INVALID_NUMBER.getMessage());
        }
    }

    private static void validateThousandUnit(final String number) {
        int money = stringToInt(number);

        if (money <= NOTHING || money % PRICE.getValue() != FIT_THOUSAND) {
            throw new IllegalArgumentException(NOT_THOUSAND_UNIT.getMessage());
        }
    }

    public static void validateWinningNumber(final String lotto) {
        String[] lottoNumbers = lotto.split(DELIMITER, LIMIT);

        validateSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        Arrays.stream(lottoNumbers).forEach(number -> validateOneNumber(number));
    }

    private static void validateOneNumber(final String number) {
        validateNumber(number);
        validateNumberSize(number);
        validateNumberInRange(Integer.parseInt(number));
    }

    private static void validateNumberInRange(final int number) {
        if (number < MINIMUM.getValue() || number > MAXIMUM.getValue()) {
            throw new IllegalArgumentException(NOT_IN_RANGE.getMessage());
        }
    }

    private static void validateSize(String[] lotto) {
        if (lotto.length != SIZE.getValue()) {
            throw new IllegalArgumentException(OUT_OF_SIZE.getMessage());
        }
    }

    private static void validateDuplicate(String[] lotto) {
        if (Arrays.stream(lotto).distinct().count() != lotto.length) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void validateBonusNumber(List<Integer> lotto, String number) {
        validateNumber(number);
        validateNumberSize(number);
        validateNumberInRange(Integer.parseInt(number));
        validateBonusDuplicate(lotto, Integer.parseInt(number));
    }

    private static void validateBonusDuplicate(List<Integer> lotto, int number) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException(BONUS_DUPLICATE.getMessage());
        }
    }
}

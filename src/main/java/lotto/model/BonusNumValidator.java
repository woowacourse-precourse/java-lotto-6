package lotto.model;

import lotto.Constants;

import java.util.List;
import java.util.regex.Matcher;

public class BonusNumValidator {

    private final List<Integer> LOTTO_NUMBERS;
    private final String BONUS_STRING;
    public final int BONUS_NUM;

    public BonusNumValidator(List<Integer> lotto, String bonus) {
            this.LOTTO_NUMBERS = lotto;
            this.BONUS_STRING = bonus;
            this.BONUS_NUM = Integer.parseInt(BONUS_STRING);
            validate();
    }

    public void validate() {
            isDuplicateNum();
            isRightNumRange();
    }

    public void isDuplicateNum() {
        if (LOTTO_NUMBERS.contains(BONUS_NUM)) {
            throw new IllegalArgumentException(Constants.BONUS_NUMBER_DUPLICATE_ERROR);
        }
    }

    public boolean isNumInRange(String input) {
        Matcher matcher = Constants.numPattern.matcher(input);
        if (matcher.matches()) {
            int number = Integer.parseInt(input);
            return true;
        }
        return false;
    }

    public void isRightNumRange() {
            boolean valid = isNumInRange(BONUS_STRING);
            if (!valid) {
                throw new IllegalArgumentException(Constants.BONUS_NUMBER_RANGE_WRONG_ERROR);
            }
        }
}

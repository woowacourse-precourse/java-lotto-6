package lotto.model;

import lotto.Constants;
import lotto.Util;

import java.util.List;
import java.util.regex.Matcher;

public class LottoNumValidator {
        public final String LOTTO_NUM_STRING;
        public final List<String> LOTTO_NUM;
        public final List<Integer> LOTTO_NUMBER;


        public LottoNumValidator(String lottoNumString) {
                this.LOTTO_NUM_STRING = lottoNumString;
                this.LOTTO_NUM = Util.toArrayList(lottoNumString);
                this.LOTTO_NUMBER = Util.toInteger(LOTTO_NUM);
                validate();
        }

        public void validate() {
                isRightNumbersString();
                isRightNumRange();
                isDuplicate();
        }

        public void isRightNumbersString() {
                if (!Constants.stringPattern.matcher(LOTTO_NUM_STRING).matches()) {
                    throw new IllegalArgumentException(Constants.WINNING_NUMBER_WRONG_ERROR);
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
                for (String number : LOTTO_NUM) {
                    boolean valid = isNumInRange(number);
                    if (!valid) {
                        throw new IllegalArgumentException(Constants.WINNING_NUMBER_RANGE_WRONG_ERROR);
                    }
                }
        }

        public void isDuplicate() {
                if (LOTTO_NUM.size() != LOTTO_NUM.stream().distinct().count()) {
                        throw new IllegalArgumentException(Constants.WINNING_NUMBER_DUPLICATE_ERROR);
                }
        }

}

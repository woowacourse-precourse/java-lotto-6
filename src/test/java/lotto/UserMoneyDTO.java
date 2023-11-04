package lotto;

import java.util.regex.Pattern;
import lotto.exception.ExceptionMessage;
import lotto.util.Parser;

public class UserMoneyDTO {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");
    private final String inputMoney;

    public UserMoneyDTO(String inputMoney) {
        validateInput(inputMoney);
        this.inputMoney = inputMoney;
    }

    public UserMoney toUserMoney() {
        return UserMoney.from(Parser.inputToNumber(inputMoney));
    }

    private void validateInput(String inputMoney) {
        isNullOrEmpty(inputMoney);
        isNumberPattern(inputMoney);
        startsWithZero(inputMoney);
    }

    private void isNullOrEmpty(String inputMoney) {
        if (inputMoney == null || inputMoney.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getErrorDescription());
        }
    }

    private void isNumberPattern(String inputMoney) {
        if (!NUMBER_PATTERN.matcher(inputMoney).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_MATCHES_NUMBER_PATTERN.getErrorDescription());
        }
    }

    private void startsWithZero(String inputMoney) {
        if (inputMoney.startsWith("0") && inputMoney.length() > 1) {
            throw new IllegalArgumentException(ExceptionMessage.MULTIPLE_LETTERS_STARTS_WITH_ZERO.getErrorDescription());
        }
    }


}

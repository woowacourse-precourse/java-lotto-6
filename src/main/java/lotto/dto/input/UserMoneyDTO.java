package lotto.dto.input;

import lotto.domain.UserMoney;
import lotto.util.Parser;
import lotto.util.validator.NumberValidator;

public class UserMoneyDTO {

    private final String inputMoney;

    public UserMoneyDTO(String inputMoney) {
        validateInput(inputMoney);
        this.inputMoney = inputMoney;
    }

    public UserMoney toUserMoney() {
        return UserMoney.from(Parser.inputToNumber(inputMoney));
    }

    private void validateInput(String inputMoney) {
        NumberValidator.isNullOrEmpty(inputMoney);
        NumberValidator.isNumberPattern(inputMoney);
        NumberValidator.startsWithZero(inputMoney);
    }
}

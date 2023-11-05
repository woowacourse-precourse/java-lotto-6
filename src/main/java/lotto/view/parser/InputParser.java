package lotto.view.parser;

import lotto.domain.UserMoney;
import lotto.view.validator.UserMoneyInputValidator;

public class InputParser {
    private final UserMoneyInputValidator userMoneyInputValidator;

    public InputParser(){
        userMoneyInputValidator = new UserMoneyInputValidator();
    }

    public UserMoney parseUserMoney(String userMoney){
        userMoneyInputValidator.validate(userMoney);
        return UserMoney.of(userMoney);
    }
}
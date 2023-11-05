package lotto.view.parser;

import lotto.view.validator.MoneyToBuyLottoInputValidator;

public class InputParser {
    private final MoneyToBuyLottoInputValidator moneyToBuyLottoInputValidator;

    public InputParser(){
        moneyToBuyLottoInputValidator = new MoneyToBuyLottoInputValidator();
    }

    public Long parseMoneyToBuyLottoToNumeric(String userInput){
        return Long.parseLong(userInput);
    }
}
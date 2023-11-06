package lotto.view.parser;

import lotto.domain.UserMoney;
import lotto.domain.WinningLottoNumbers;
import lotto.view.constant.InputConstant;
import lotto.view.validator.UserMoneyInputValidator;
import lotto.view.validator.WinningLottoNumbersInputValidator;

public class InputParser {
    private final UserMoneyInputValidator userMoneyInputValidator;
    private final WinningLottoNumbersInputValidator winningLottoNumbersInputValidator;

    public InputParser(){
        userMoneyInputValidator = new UserMoneyInputValidator();
        winningLottoNumbersInputValidator = new WinningLottoNumbersInputValidator();
    }

    public UserMoney parseUserMoney(String userMoney){
        userMoney = removeBlank(userMoney);
        userMoneyInputValidator.validate(userMoney);
        return UserMoney.of(userMoney);
    }

    public WinningLottoNumbers parseWinningLottoNumbers(String winningLottoNumbers){
        winningLottoNumbersInputValidator.validate(winningLottoNumbers);
        return WinningLottoNumbers.of(winningLottoNumbers);
    }

    private String removeBlank(String userInput){
        if(userInput.contains(InputConstant.BLANK_SYMBOL)){
            userInput = userInput.replace(InputConstant.BLANK_SYMBOL, InputConstant.VOID_SYMBOL);
        }
        return userInput;
    }
}
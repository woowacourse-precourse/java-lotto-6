package lotto.view;

import lotto.exception.BonusNumberException;
import lotto.util.StringToIntegerConverter;

public class BonusNumberInputView extends InputView {
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private BonusNumberException bonusNumberException = new BonusNumberException();
    private StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();

    public int getBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = getInputValue();
        bonusNumberException.isNumber(input);
        bonusNumberException.isNumberOnlyOne(input);
        bonusNumberException.isBlank(input);
        int bonusNum = stringToIntegerConverter.stringToInteger(input);
        bonusNumberException.isRightRange(bonusNum);

        return bonusNum;
    }
}

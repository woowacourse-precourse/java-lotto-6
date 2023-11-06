package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BonusNumberException;
import lotto.util.Converter;

public class BonusNumberInputView extends InputView {
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private BonusNumberException bonusNumberException = new BonusNumberException();
    private Converter converter = new Converter();

    public int getBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = getInputValue();
        bonusNumberException.isNumber(input);
        bonusNumberException.isNumberOnlyOne(input);
        bonusNumberException.isBlank(input);
        int bonusNum = converter.stringToInteger(input);
        bonusNumberException.isRightRange(bonusNum);

        return bonusNum;
    }
}

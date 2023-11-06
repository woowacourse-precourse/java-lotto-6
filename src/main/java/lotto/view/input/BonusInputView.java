package lotto.view.input;

import java.util.List;
import lotto.exception.Exceptions;
import lotto.view.Prompt;

public class BonusInputView extends InputView {
    private int bonusNumber;

    @Override
    protected void Validation(String inputMessage) {
        Exceptions.checkIsNumber(inputMessage);
        bonusNumber = Integer.parseInt(inputMessage);

        Exceptions.checkLottoRange(List.of(bonusNumber));
    }

    public int getBonusNumber() {
        getInput(Prompt.BONUS_NUMBER_OF_LOTTO);
        return bonusNumber;
    }
}

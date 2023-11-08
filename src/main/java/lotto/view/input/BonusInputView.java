package lotto.view.input;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.Exceptions;
import lotto.view.Prompt;

public class BonusInputView extends InputView {
    private int bonusNumber;

    @Override
    protected void Validation(String inputMessage) {
        Exceptions.checkIsNumber(inputMessage);
        bonusNumber = Integer.parseInt(inputMessage);

        List<Integer> tmp = new ArrayList<>(lottoNumbers);
        tmp.add(bonusNumber);

        Exceptions.checkLottoDuplicate(tmp);
        Exceptions.checkLottoRange(List.of(bonusNumber));
    }

    public int getBonusNumber() {
        getInput(Prompt.BONUS_NUMBER_OF_LOTTO);
        return bonusNumber;
    }
}
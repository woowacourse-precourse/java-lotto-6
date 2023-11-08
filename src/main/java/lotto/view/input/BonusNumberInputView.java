package lotto.view.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.Message;

public class BonusNumberInputView implements InputView {
    @Override
    public String inputBonusNumber() {
        System.out.println();
        System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
        return Console.readLine();
    }
}

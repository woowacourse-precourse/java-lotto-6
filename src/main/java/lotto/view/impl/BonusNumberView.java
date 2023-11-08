package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.view.Inputable;
import lotto.view.View;

public class BonusNumberView extends View implements Inputable {
    private final static String bonusNumberInputText = "보너스 번호를 입력해 주세요.";

    @Override
    public Object inputView() {
        printView(bonusNumberInputText);

        return new BonusNumber(Console.readLine());
    }


}

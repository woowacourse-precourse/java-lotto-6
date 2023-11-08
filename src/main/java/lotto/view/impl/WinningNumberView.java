package lotto.view.impl;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.view.Inputable;
import lotto.view.View;

public class WinningNumberView extends View implements Inputable {
    private final static String numberInputText = "당첨 번호를 입력해 주세요.";

    @Override
    public Object inputView() {
        printView(numberInputText);
        String numbers = Console.readLine();

        return new Lotto(numbers);
    }
}

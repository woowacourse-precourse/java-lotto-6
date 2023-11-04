package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.dto.InputMoney;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";

    public static InputMoney inputMoney(){
        return new InputMoney(Console.readLine());
    }
}

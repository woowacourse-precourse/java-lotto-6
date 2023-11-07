package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.dto.InputMoney;
import lotto.domain.dto.InputWinningNumbers;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";

    public static InputMoney inputMoney() {
        System.out.println(INPUT_MONEY);
        return new InputMoney(Console.readLine());
    }

    public static InputWinningNumbers inputWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
        return new InputWinningNumbers(Console.readLine());
    }
}

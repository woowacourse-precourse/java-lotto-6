package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.InputValidator;

public class InputView {

    public static int inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}

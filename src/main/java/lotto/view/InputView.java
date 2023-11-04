package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Util;

public class InputView {
    public static int inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        String input = Console.readLine();
        validateInt(input);
        return Util.stringToInt(input);
    }


    private static void validateInt(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}

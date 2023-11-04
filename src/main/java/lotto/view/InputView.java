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

    public static String[] inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String[] input = Console.readLine().split(",");
        InputValidator.validateIsAllNumber(input);
        return input;
    }

    public static int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        InputValidator.validateIsNumber(input);
        return Integer.parseInt(input);
    }
}

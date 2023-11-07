package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Converter;
import lotto.utils.InputValidator;

import java.util.List;

public class InputView {
    public static long inputMoney() {
        System.out.println("금액을 입력하세요.");
        String money = Console.readLine();
        InputValidator.validateInputMoney(money);

        return Converter.convertMoney(money);
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println("당첨 번호를 입력하세요.");
        String winningNumber = Console.readLine();
        String[] numbers = winningNumber.split(",");
        InputValidator.validateInputWinningNumber(numbers);

        return Converter.convertWinningNumber(numbers);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력하세요.");
        String bonusNumber = Console.readLine();
        InputValidator.validateBonusNumber(bonusNumber);

        return Integer.parseInt(bonusNumber);
    }
}

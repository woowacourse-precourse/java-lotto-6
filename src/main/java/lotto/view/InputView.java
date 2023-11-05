package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.utils.InputParser;

public class InputView {
    private final static String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Console.readLine();
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        InputParser inputParser = new InputParser();
        return inputParser.parseAndValidateWinningNumbers(Console.readLine());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(Console.readLine());
    }
}

package lotto.View;

import static lotto.Util.InputValidator.isEmpty;
import static lotto.Util.InputValidator.isNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_LOTTO_PUCAHSE_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputLottoPurchaseAmount() {
        String input = "";
        try {
            System.out.println(INPUT_LOTTO_PUCAHSE_AMOUNT_MESSAGE);
            input = Console.readLine();
            isNumber(input);
            isEmpty(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoPurchaseAmount();
        }
        return input;
    }

    public static String inputLottoWinningNumber() {
        String input = "";
        try {
            System.out.println(INPUT_LOTTO_WINNING_NUMBER_MESSAGE);
            input = Console.readLine();
            isNumber(input);
            isEmpty(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoWinningNumber();
        }
        return input;
    }

    public static String inputLottoBonusNumber() {
        String input = "";
        try {
            System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
            input = Console.readLine();
            isNumber(input);
            isEmpty(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLottoBonusNumber();
        }
        return input;
    }
}

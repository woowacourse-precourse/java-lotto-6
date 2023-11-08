package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.validation.WinningNumberValidation;

public class InputView {

    public enum Prompt {
        LOTTO_AMOUNT("구입금액을 입력해 주세요."),
        LOTTO_WINNING("당첨 번호를 입력해 주세요."),
        BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        Prompt(String message) {
            this.message = message;
        }

        public void display() {
            System.out.println(message);
        }
    }

    public static String inputLottoMoney() {
        Prompt.LOTTO_AMOUNT.display();
        return Console.readLine();
    }

    public static List<Integer> inputLottoWinningNum() {
        Prompt.LOTTO_WINNING.display();
        String winningNumberStr = Console.readLine();
        return WinningNumberValidation.validateWinningNumbers(winningNumberStr);
    }

    public static String inputBonusNumber() {
        Prompt.BONUS_NUMBER.display();
        return Console.readLine();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Bonus;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.utils.Parser;

public class InputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요.\n"),
        INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public Budget inputBudget() {
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        String input = Console.readLine();
        return Parser.parseToBudget(input);
    }


    public Lotto inputWinningNumbers() {
        System.out.printf(ConsoleMessage.INPUT_WINNING_NUMBER.message);
        String input = Console.readLine();
        return Parser.parseToLotto(input);
    }

    public Bonus inputBonusNumbers() {
        System.out.printf(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String input = Console.readLine();
        return Parser.parseToBonus(input);
    }


}

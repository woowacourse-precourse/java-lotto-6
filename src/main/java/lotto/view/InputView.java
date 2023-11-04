package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.utils.Parser;
import lotto.utils.validator.BudgetValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_BUDGET("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int inputBudget(){
        System.out.println(ConsoleMessage.INPUT_BUDGET.message);
        String input = Console.readLine();
        int budget = Parser.parseBudget(input);
        new BudgetValidator().validate(budget);
        return budget;
    }

    public Lotto inputWinningNumbers(){
        System.out.println(ConsoleMessage.INPUT_WINNING_NUMBER.message);
        String input = Console.readLine();
        return Parser.parseToLotto(input);
    }

    public Bonus inputBonusNumbers(){
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String input = Console.readLine();
        return Parser.parseToBonus(input);
    }


}

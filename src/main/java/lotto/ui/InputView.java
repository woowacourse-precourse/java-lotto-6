package lotto.ui;

import static lotto.constants.PromptMessage.INPUT_BONUS_NUMBERS_PROMPT;
import static lotto.constants.PromptMessage.INPUT_PRICE_PROMPT;
import static lotto.constants.PromptMessage.INPUT_WINNING_NUMBERS_PROMPT;

public class InputView {
    public void printInputPricePrompt() {
        System.out.println(INPUT_PRICE_PROMPT);
    }

    public void printInputWinningNumbersPrompt() {
        System.out.println(INPUT_WINNING_NUMBERS_PROMPT);
    }

    public void printInputBonusNumberPrompt() {
        System.out.println(INPUT_BONUS_NUMBERS_PROMPT);
    }
}

package lotto;

import static lotto.resource.TextResourceProvider.INPUT_BONUS_NUMBER_TEXT;
import static lotto.resource.TextResourceProvider.INPUT_WINNING_NUMBERS_TEXT;
import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT;

public class Application {
    public static void main(String[] args) {
        InputInterface in = new InputInterface();
        long purchasedAmount = in.getPurchasedAmount();
        System.out.println(INPUT_WINNING_NUMBERS_TEXT);
        System.out.println(INPUT_BONUS_NUMBER_TEXT);
        System.out.println(OUTPUT_LOTTERY_RESULT);
    }
}

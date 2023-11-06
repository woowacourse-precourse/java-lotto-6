package view;

import camp.nextstep.edu.missionutils.Console;
import util.InputMessage;
import view.validator.PriceFormatValidator;

public class InputView {

    private static final PriceFormatValidator priceFormatValidator = new PriceFormatValidator();

    public static String enterPrice() {
        System.out.println(InputMessage.ENTER_PRICE.getInputMessage());
        String input = Console.readLine();
        priceFormatValidator.checkPriceFormat(input);
        return input;
    }

    public static String enterWinningNumbers() {
        System.out.println(InputMessage.ENTER_WINNING_NUMBERS.getInputMessage());
        String input = Console.readLine();
        return input;
    }

    public static String enterBonusNumbers() {
        System.out.println(InputMessage.ENTER_BONUS_NUMBERS.getInputMessage());
        String input = Console.readLine();
        return input;
    }
}

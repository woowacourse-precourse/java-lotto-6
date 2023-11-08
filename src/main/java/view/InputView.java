package view;

import camp.nextstep.edu.missionutils.Console;
import util.InputMessage;
import view.validator.PriceFormatValidator;
import view.validator.WinningNumberFormatValidator;

public class InputView {

    private static final PriceFormatValidator priceFormatValidator = new PriceFormatValidator();
    private static final WinningNumberFormatValidator winningNumberValidation = new WinningNumberFormatValidator();

    public static String enterPrice() {
        System.out.println(InputMessage.ENTER_PRICE.getInputMessage());
        String input = Console.readLine();
        priceFormatValidator.checkPriceFormat(input);
        return input;
    }

    public static String enterWinningNumbers() {
        System.out.println(InputMessage.ENTER_WINNING_NUMBERS.getInputMessage());
        String input = Console.readLine();
        winningNumberValidation.checkWinningNumberValidation(input);
        return input;
    }

    public static String enterBonusNumbers() {
        System.out.println(InputMessage.ENTER_BONUS_NUMBERS.getInputMessage());
        String input = Console.readLine();
        return input;
    }
}

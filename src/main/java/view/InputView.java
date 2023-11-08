package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import util.ValidationBonusNumber;
import util.ValidationNumbers;
import util.ValidationPrice;

public class InputView {

    private static final Integer removeLastSpaceNumber = 0;

    public static Integer inputPurchasePrice() {
        String message = InputMessages.PURCHASE_MESSAGE.getMessage();
        System.out.println(message);
        String priceString = input();
        ValidationPrice.validatePrice(priceString);
        Integer price = Integer.parseInt(priceString);
        return price;
    }

    public static List<Integer> inputWinningNumbers() {
        String message = InputMessages.WINNING_NUMBER_MESSAGE.getMessage();
        System.out.println(message);
        String winningNumbers = input();
        ValidationNumbers.validateNumbers(winningNumbers);
        return Arrays.stream(winningNumbers.split(",", removeLastSpaceNumber))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static Integer inputBonusNumber() {
        String message = InputMessages.BONUS_NUMBER_MESSAGE.getMessage();
        System.out.println(message);
        String bonusNumberString = input();
        ValidationBonusNumber.validateBonusNumber(bonusNumberString);
        Integer bonusNumber = Integer.parseInt(bonusNumberString);
        return bonusNumber;
    }

    public static String input() {
        return Console.readLine();
    }
}

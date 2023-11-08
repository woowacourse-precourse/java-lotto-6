package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

import static lotto.constant.ViewMessage.*;

public class InputView {

    public static int requestPurchaseAmount() {
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
        String input = Console.readLine();
        Validator.checkNumberType(input);
        return Integer.parseInt(input);
    }

    public static String[] requestWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS.getMessage());
        String[] inputs = Console.readLine().split(",");
        Validator.checkAllNumberType(inputs);
        return inputs;
    }

    public static int requestBonusNumber() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER.getMessage());
        String input = Console.readLine();
        Validator.checkNumberType(input);
        return Integer.parseInt(input);
    }

}

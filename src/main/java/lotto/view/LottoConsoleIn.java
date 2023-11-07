package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.InputValidator;

public class LottoConsoleIn {

    private final static InputValidator validator = new InputValidator();

    public static Long inputPurchaseAmount(){
        String input = Console.readLine();
        return validator.validatePurchaseAmount(input);
    }


    public static String inputNumberOfWinningNumbers(){
        String input =Console.readLine();
        return validator.validateWinningInput(input);
    }

    public static Integer inputBonusNumber(){
        String input = Console.readLine();
        return validator.validateBonusNumber(input);
    }

}

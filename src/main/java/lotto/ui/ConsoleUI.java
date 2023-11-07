package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validator;

public class ConsoleUI {
    private final Validator validator;

    public ConsoleUI(Validator validator) {
        this.validator = validator;
    }

    public int getPurchaseAmount(){
        String input = Console.readLine();
        validator.validateInteger(input);
        int lottoPurchaseCost = Integer.parseInt(input);
        validator.validatePositiveInteger(lottoPurchaseCost);
        validator.validateAmountInThousands(lottoPurchaseCost);
        return lottoPurchaseCost;
    }




}

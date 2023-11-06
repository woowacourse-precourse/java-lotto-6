package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoPurchaseAmountException;
import lotto.util.StringToIntegerConverter;

public class LottoPurchaseAmountInputView extends InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private LottoPurchaseAmountException lottoPurchaseAmountException = new LottoPurchaseAmountException();
    private StringToIntegerConverter stringToIntegerConverter = new StringToIntegerConverter();

    public int getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        getInputValue();
        String input = Console.readLine();
        lottoPurchaseAmountException.isNumber(input);
        lottoPurchaseAmountException.isBlank(input);
        int purchaseAmount = stringToIntegerConverter.stringToInteger(input);
        lottoPurchaseAmountException.isDivideThousand(purchaseAmount);
        return purchaseAmount;
    }

}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.LottoPurchaseAmountException;
import lotto.util.StringToIntegerConverter;

public class LottoPurchaseAmountInputView extends InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public String getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return getInputValue();
    }

}

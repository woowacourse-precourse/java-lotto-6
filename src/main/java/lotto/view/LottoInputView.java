package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.LottoValidation;

import java.util.List;

public class LottoInputView {
    private static final String PURCHASE_AMOUNT_ERROR_MSG = "[ERROR] 구입 금액은 1,000원 단위여야 합니다.";

    public int inputPurchaseAmount(final LottoValidation lottoValidation) {
        String userInput = Console.readLine();
        if (!lottoValidation.validate(userInput)) throw new IllegalArgumentException(PURCHASE_AMOUNT_ERROR_MSG);
        return Integer.parseInt(userInput);
    }

}

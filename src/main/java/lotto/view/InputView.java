package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.LottoValidation;

public class InputView {

    public int readPurchaseAmount(LottoValidation lottoValidation) {
        String userInput = Console.readLine();
        lottoValidation.validatePurchaseAmount(userInput);
        return Integer.parseInt(userInput);
    }
}

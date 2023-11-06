package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.model.LottoPrice;

public class InputView {

    public int inputLottoPrice() {
        System.out.println(OutputType.INPUT_PURCHASE_AMOUNT_MESSAGE.getValue());
        String userInputPrice = Console.readLine();
        return Integer.parseInt(userInputPrice);
    }


}

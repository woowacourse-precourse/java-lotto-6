package lotto.view;

import static lotto.view.LottoConsole.*;
import static lotto.view.LottoConstants.*;

public class OutputView {

    public void printNumberOfLottos(int numberOfLottos) {
        String message = String.format(MSG_PURCHASE_COUNT_PROMPT, numberOfLottos);
        print(message);
    }
}

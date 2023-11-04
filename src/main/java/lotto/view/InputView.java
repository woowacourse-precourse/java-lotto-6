package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoCounter;

public class InputView {

    public LottoCounter readPurchaseAmount() {
        String input = Console.readLine();
        return new LottoCounter(Integer.parseInt(input));
    }
}

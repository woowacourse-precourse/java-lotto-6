package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringUtils;

import java.util.List;

public class InputView {

    public int readPurchaseAmount() {
        String purchaseAmountInput = Console.readLine();
        return StringUtils.stringToInt(purchaseAmountInput);
    }

    public List<Integer> readWinnerNumbers() {
        String winnerNumberInput = Console.readLine();
        List<String> winnerNumbers = StringUtils.splitString(winnerNumberInput);
        return StringUtils.convertToIntegerList(winnerNumbers);
    }
}

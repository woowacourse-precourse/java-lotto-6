package lotto.view;

import lotto.util.Convert;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public Integer readPurchaseAmount() {
        return Convert.stringToInteger(readLine());
    }

    public List<Integer> readWinningNumbers() {
        return Convert.stringToIntegerList(readLine());
    }
}

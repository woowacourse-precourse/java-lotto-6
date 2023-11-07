package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String REGEX = ",";

    private String request() {
        return Console.readLine();
    }

    public String requestPurchaseAmount() {
        return request();
    }

    public List<String> requestWinningNumber() {
        String winningNumberInput = request();
        return Arrays.stream(winningNumberInput.split(REGEX))
                .map(String::trim).toList();
    }

    public String requestBonusNumber() {
        return request();
    }
}

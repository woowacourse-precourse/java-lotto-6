package lotto.view;

import static lotto.constant.LottoSetting.REGEX;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private String request() {
        return Console.readLine();
    }

    public String requestPurchaseAmount() {
        return request();
    }

    public List<String> requestWinningNumber() {
        String winningNumberInput = request();
        return Arrays.stream(winningNumberInput.split(REGEX.toString()))
                .map(String::trim).toList();
    }
}

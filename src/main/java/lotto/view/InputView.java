package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public String inputLottoPurchaseAmount() {
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        return Console.readLine();
    }
}

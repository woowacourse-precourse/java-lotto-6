package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Utils;

public final class InputView {

    private InputView() {
    }

    public static int inputNumber() {
        return Utils.convertStringToInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumbers() {
        return Utils.convertStringToIntegerList(Console.readLine());
    }
}

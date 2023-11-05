package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.Utils;

public class InputView {

    public int inputNumber() {
        return Utils.convertStringToInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        return Utils.convertStringToIntegerList(Console.readLine());
    }
}

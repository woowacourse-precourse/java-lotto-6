package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class WinningLottoInputView {

    public static List<String> inputWinningLottoNumbers() {

        ConsoleMessageView.printWinningLottoNumbersInputMessage();

        String winningLottos = Console.readLine();

        return Arrays.stream(winningLottos.split(","))
                     .toList();
    }

    public static String inputBonusNumber() {
        ConsoleMessageView.printBonusNumberInputMessage();

        return Console.readLine();
    }

}

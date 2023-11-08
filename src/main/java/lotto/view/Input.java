package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.Util.Util;

public class Input {
    public static int inputPayment() {
        String payment = Console.readLine();
        return Util.inputNumberToInteger(payment);
    }

    public static List<Integer> inputLotto() {
        String lotto = Console.readLine();
        List<String> splitLotto = Util.splitNumbersByComma(lotto);
        return Util.lottoToInteger(splitLotto);
    }

    public static int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        return Util.inputNumberToInteger(bonusNumber);
    }
}

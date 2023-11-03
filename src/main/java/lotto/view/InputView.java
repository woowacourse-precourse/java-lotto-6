package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constants.Phrase;

public class InputView {
    public static String getLottoAmount() {
        System.out.println(Phrase.INPUT_LOTTO_AMOUNT.getMessage());
        return Console.readLine();
    }
}

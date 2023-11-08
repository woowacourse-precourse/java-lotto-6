package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.common.Validation;

public class InputView {

    public Integer inputPrice() {
        String strPrice = Console.readLine()
                .trim();

        Validation.onlyNumberCheck(strPrice);

        return Integer.parseInt(strPrice);
    }

    public String inputLotto() {
        return Console.readLine();
    }

    public String inputBonus() {
        return Console.readLine();
    }
}

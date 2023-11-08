package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.NumberUtils;

public class InputView {

    private InputView() {

    }

    public static int getInputNumber() {

        System.out.println("구입금액을 입력해 주세요.");
        return NumberUtils.checkNumber(Console.readLine());
    }
}

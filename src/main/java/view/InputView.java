package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private InputView() {}

    public static String inputMoney() {
        System.out.println("구입할 금액을 입력해 주세요.");
        return Console.readLine();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요";

    public String insertMoney() {
        return inputTemplate(INSERT_MONEY);
    }

    private String inputTemplate(String message) {
        printMessage(message);
        return Console.readLine();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INSERT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String insertMoney() {
        return inputTemplate(INSERT_MONEY);
    }

    public String inputNumbers() {
        return inputTemplate(INPUT_NUMBERS);
    }

    public String inputBonusNumber() {
        return inputTemplate(INPUT_BONUS_NUMBER);
    }

    private String inputTemplate(String message) {
        printMessage(message);
        String input = Console.readLine();
        printEmptyLine();
        return input;
    }

    private void printMessage(String message) {
        System.out.println(message);
    }

    private void printEmptyLine() {
        System.out.println();
    }
}

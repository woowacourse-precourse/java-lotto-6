package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    AMOUNT("구입금액을 입력해 주세요."),
    LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUMS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputView(String message) {
        this.message = message;
    }

    public String getInput() {
        System.out.println(message);
        return Console.readLine();
    }
}
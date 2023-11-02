package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getPayment() {
        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();
        return input;
    }
}

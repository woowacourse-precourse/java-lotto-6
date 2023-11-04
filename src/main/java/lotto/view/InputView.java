package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int requestPrice() {
        System.out.println("구입 금액을 입력해주세요.");
        String answer = Console.readLine();
        System.out.println();
        return Integer.parseInt(answer);
    }
}

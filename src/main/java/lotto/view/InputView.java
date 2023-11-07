package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        String input = readLine();
        return Integer.parseInt(input);
    }
}

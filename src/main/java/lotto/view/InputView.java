package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }
}

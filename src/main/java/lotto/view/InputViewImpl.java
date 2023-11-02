package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLine();
    }

    protected String readLine() {
        return Console.readLine();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public long purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.parseLong(Console.readLine());
    }
}

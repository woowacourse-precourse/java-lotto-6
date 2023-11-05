package lotto.views;

import camp.nextstep.edu.missionutils.Console;

public class InputViews {
    public int readPurchaseAmount () {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

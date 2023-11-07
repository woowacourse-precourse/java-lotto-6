package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}

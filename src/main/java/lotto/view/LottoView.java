package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {

    public String input(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    public int inputPurchaseAmount() {
        String input = input("구입금액을 입력해 주세요.");
        return Integer.parseInt(input);
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    public String purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요");
        return Console.readLine();
    }

    public String winNum() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNum() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

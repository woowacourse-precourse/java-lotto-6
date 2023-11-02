package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Integer inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
}

package lotto.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 구매할 금액을 입력받는 화면을 출력하는 View
 */
public class InputPurchaseView {
    /**
     * 구매할 금액을 입력하라고 출력하고 입력받는 메서드
     *
     * @return 입력받은 String
     */
    public String printPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("");
        return input;
    }
}

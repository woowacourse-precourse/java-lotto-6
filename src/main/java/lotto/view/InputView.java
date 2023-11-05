package lotto.view;

import static lotto.util.util.println;

import camp.nextstep.edu.missionutils.Console;

/* 입력 '만' 받는 클래스
* */
public class InputView {
    String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    // 구입금액 입력 메세지 출력
    public void printInputPurchaseAmountMessage() {
        println(INPUT_PURCHASE_AMOUNT);
    }

    // 구입금액 입력 받기
    public String inputPurchaseAmount() {
        return Console.readLine();
    }
}

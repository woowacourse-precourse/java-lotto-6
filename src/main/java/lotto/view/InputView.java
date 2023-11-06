package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String buyAmountInput = "구매 금액을 입력해주세요";

    public int readBuyAmount(){
        System.out.println(buyAmountInput);

        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}

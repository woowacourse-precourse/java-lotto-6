package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String MESSAGE_ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int purchaseLottoAmount(){
        System.out.println(MESSAGE_ENTER_PURCHASE_AMOUNT);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }

}

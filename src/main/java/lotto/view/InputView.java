package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_LOTTO_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_LOTTO_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseAmount(){
        System.out.println(INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumber(){
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println();
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

}

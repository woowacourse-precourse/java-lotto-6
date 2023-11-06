package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String getPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getWinnerNumber(){
        System.out.println(WINNER_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String getBonusNumber(){
        System.out.println(BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}

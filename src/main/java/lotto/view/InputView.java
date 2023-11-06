package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.WinningNumber;

public class InputView {
    private static final String INPUT_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String INPUT_SELECT_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String inputPurchaseCost(){
        System.out.println(INPUT_PURCHASE_COST);
        return Console.readLine();
    }

    public String inputSelectNumber(){
        System.out.println("\n"+INPUT_SELECT_NUMBER);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println("\n"+INPUT_BONUS_NUMBER);
        return Console.readLine();
    }






}

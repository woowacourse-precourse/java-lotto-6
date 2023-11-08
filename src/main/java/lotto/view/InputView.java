package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_COST = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    /**
     * 구입 금액 입력 요청 뷰
     */
    public String inputPurchaseCost(){
        System.out.println(INPUT_PURCHASE_COST);
        return Console.readLine();
    }

    /**
     * 당첨번호 입력하는 뷰
     */
    public String inputWinningNumber(){
        System.out.println("\n"+INPUT_WINNING_NUMBER);
        return Console.readLine();
    }


    /**
     * 보너스 번호 입력하는 뷰
     */
    public String inputBonusNumber(){
        System.out.println("\n"+INPUT_BONUS_NUMBER);
        return Console.readLine();
    }






}

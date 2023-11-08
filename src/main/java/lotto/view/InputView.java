package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String PURCHASE_PIRCE_REQUEST_MESSAGE = "구매 금액을 입력해 주세요.";
    private final static String WINNING_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 번호를 입력해 주세요.";


    public static void requestPurchaseAmount(){
        System.out.println(PURCHASE_PIRCE_REQUEST_MESSAGE);
    }
    public static void askCommonWinningNumbersMessage(){
        System.out.println(WINNING_NUMBERS_REQUEST_MESSAGE);
    }
    public static void askBonusNumberMessage(){
        System.out.println(BONUS_NUMBER_REQUEST_MESSAGE);
    }
}

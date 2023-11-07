package lotto.view;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBERS = "보너스 번호를 입력해 주세요.";

    public static void noticeToGetPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void noticeToGetWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void noticeToGetBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBERS);
    }

}

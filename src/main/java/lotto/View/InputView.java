package lotto.View;

public class InputView {
    private static final String INPUT_TICKETS_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printTicketsAmount(){
        System.out.println(INPUT_TICKETS_AMOUNT);
    }
    public static void printWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }
    public static void printBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
    }

}

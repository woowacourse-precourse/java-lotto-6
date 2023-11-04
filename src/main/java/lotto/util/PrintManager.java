package lotto.util;

public class PrintManager {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printInputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS);
    }

    public static void printBonusNumberInput() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
}

package lotto.util;

public class LottoProperties {
    private static String INPUT_PURCHASE_MONEY = "구입급액을 입력해 주세요.";
    private static String BUY_COUNT = "개를 구매했습니다.";
    private static String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getInputPurchaseMoney() {
        return INPUT_PURCHASE_MONEY;
    }

    public static String getInputWinningNumber() {
        return INPUT_WINNING_NUMBER;
    }

    public static String getInputBonusNumber() {
        return INPUT_BONUS_NUMBER;
    }

    public static String getBuyCount(int money) {
        return (money / 1000) + BUY_COUNT;
    }
}

package util;

public class InputView {
    private static final String INPUT_LOTTO = "당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해주세요";
    private static final String INPUT_USER_MONEY = "구입금액을 입력해주세요.";
    public static void printUserInputLotto() {
        System.out.println(INPUT_LOTTO);
    }
    public static void printUserBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
    public static void printUserMoney() {
        System.out.println(INPUT_USER_MONEY);
    }
}

package lotto.view;

public class OutputView {

    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String PURCHASED = "개를 구매했습니다.";
    private static final String INPUT_WIN_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";


    public static void printInputMoney() {
        System.out.println(INPUT_MONEY);
    }

    public static void printPurchased(int size) {
        System.out.println("\n" + size + PURCHASED);
    }

    public static void printGeneratedLotto(String lottos) {
        System.out.println(lottos);
    }
    public static void printInputWinNumber() {
        System.out.println(INPUT_WIN_NUMBER);
    }
    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }
    public static void printWinStatistics(String result) {
        System.out.println(result);
    }
}

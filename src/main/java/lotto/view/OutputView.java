package lotto.view;

public class OutputView {
    public static void printGetMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printGetWinningNumberMessage() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printGetBonusNumberMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printCommonString(String string) {
        System.out.println(string);
    }

    public static void printLottoCount(int money) {
        System.out.printf("\n%d개를 구매했습니다.\n", money);
    }
}

package ui;

import java.text.MessageFormat;

class OutputView {
    private OutputView() {
    }

    public static void sayMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public static void sayAmount(int amount) {
        String formatted = MessageFormat.format("{0}개를 구매했습니다.", amount);
        System.out.println(formatted);
    }

    public static void sayLottos(Object lottos) {
        System.out.println();
    }

    public static void sayWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void sayBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void sayResult() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}

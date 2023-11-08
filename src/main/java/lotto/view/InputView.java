package lotto.view;

import lotto.controller.LottoController;


public class InputView {
    LottoController controller = new LottoController();

    public static void showInputPurchaseMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    private void newLine() {
        System.out.println();
    }

    public static void showInputWinningNumbersMessage() {
        System.out.println("당첨 번호를 입력해주세요.");
    }

    public static void showInputBonusNumberMessage() {
        System.out.println("보너스 번호를 입력해주세요.");
    }

}

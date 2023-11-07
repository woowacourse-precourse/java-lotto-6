package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class ConsoleView {
    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printTicketCount(int count) {
        System.out.printf(("%d개를 구매했습니다.\n"), count);
    }

    public static void printErrorMessage(String message) {
        System.out.println("[ERROR] " + message);
    }

    public static void printPriceExplanation() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printWinningNumberExplanation() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberExplanation() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}

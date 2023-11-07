package view;

import domain.Lotto;
import java.util.List;

public class OutputView {
    public static void printInputSpend() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printPurchaseCount(int spend) {
        System.out.printf("\n%d개를 구매했습니다.\n", spend / 1000);
    }

    public static void printLottoNumbers(List<Lotto> lottoTickets) {
        for (Lotto lottoNumbers : lottoTickets) {
            System.out.println(lottoNumbers);
        }
    }

    public static void printInputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }
}

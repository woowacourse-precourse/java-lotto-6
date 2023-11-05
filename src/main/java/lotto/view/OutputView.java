package lotto.view;

import lotto.model.Lotto;
import lotto.service.LottoService;

import java.util.List;

public class OutputView {
    public static void printInputMoneyMsg() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printAmountOfLottoTickets() {
        int amount = LottoService.getAmountOfLottoTickets();
        System.out.printf("%d개를 구매했습니다.|n", amount);
    }
    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets);
    }
    public static void printInputWinningNumbersMsg() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    public static void printInputBonusNumberMsg() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    public static void printStatistics() {

    }
    public static void printEarningRate() {

    }
}

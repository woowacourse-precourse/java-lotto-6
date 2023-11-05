package lotto.view;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.WiningRank;
import lotto.service.LottoService;
import lotto.service.ProfitsService;

public class OutputView {

    private static final String PURCHASE_QUANTITY_INFORMATION = "개를 구매했습니다.";
    private static final String WINING_RESULT_INFORMATION = "당첨 통계";
    private static final String SEPARATION_INDICATION = "---";
    private static final String WINING_STATISTICS_BONUS = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String WINING_STATISTICS = "%d개 일치 (%,d원) - %d개";


    public static void printPurchaseLotto(Buyer buyer) {
        printPurchaseQuantity(buyer.getPurchaselottoQuantity());
        printLottoNumbers(buyer);
    }

    public static void printWiningWiningResult(LottoService lottoService) {
        printResultMessage();
        printWiningStatistics(lottoService);
    }

    public static void printRateOfReturn(ProfitsService profitsService) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", profitsService.getRateOfReturn()));
    }

    private static void printPurchaseQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + PURCHASE_QUANTITY_INFORMATION);
    }

    private static void printLottoNumbers(Buyer buyer) {
        for (Lotto lotto : buyer.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    private static void printResultMessage() {
        System.out.println();
        System.out.println(WINING_RESULT_INFORMATION);
        System.out.println(SEPARATION_INDICATION);
    }

    private static void printWiningStatistics(LottoService lottoService) {
        for (WiningRank rank : lottoService.getWiningDetails().keySet()) {
            String message = WINING_STATISTICS;
            if (rank.getWiningAmount() == 30_000_000) {
                message = WINING_STATISTICS_BONUS;
            }

            System.out.println(String.format(message, rank.getMatchCount(), rank.getWiningAmount(),
                    lottoService.getWiningDetails().get(rank)));
        }
    }
}

package lotto.view;

import java.text.DecimalFormat;
import java.util.Arrays;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.dto.LottoResultDTO;
import lotto.domain.dto.PurchasedLottoDTO;

public class OutputView {
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String SEPARATOR = "---";

    public static void printPurchasedLotto(PurchasedLottoDTO purchasedLottoDTO) {
        System.out.println(purchasedLottoDTO.getPurchasedLotto().size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottoDTO.getPurchasedLotto()) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void printLottoResult(LottoResultDTO lottoResultDTO) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(SEPARATOR);
        LottoRank[] ranks = LottoRank.values();
        for (int i = 4; i >= 0; i--) {
            LottoRank rank = ranks[i];
            int count = lottoResultDTO.getLottoResultInfo().getOrDefault(rank, 0);
            System.out.printf("%s (%,d원) - %d개%n", rank.getWinningMessage(), rank.getMoney(), count);
        }
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println((exception.getMessage()));
    }

    public static void printProfit(Double userProfit){
        DecimalFormat decimalFormat = new DecimalFormat("########.##");
        System.out.println(decimalFormat.format(userProfit) + '%');
    }
}

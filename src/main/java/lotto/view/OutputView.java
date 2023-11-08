package lotto.view;

import static lotto.view.utils.GameMessage.LOTTO_RESULT_MESSAGE;
import static lotto.view.utils.GameMessage.PROFIT_MESSAGE;
import static lotto.view.utils.GameMessage.PURCHASE_MESSAGE;
import static lotto.view.utils.GameMessage.RESULT_MESSAGE;
import static lotto.view.utils.GameMessage.SEPARATOR;

import java.util.Arrays;
import lotto.Lotto;
import lotto.domain.LottoRank;
import lotto.dto.LottoResultDTO;
import lotto.dto.PurchasedLottoDTO;

public class OutputView {

    public static void printPurchasedLotto(PurchasedLottoDTO purchasedLottoDTO) {
        System.out.println();
        System.out.println(purchasedLottoDTO.getPurchasedLotto().size() + PURCHASE_MESSAGE.getMessage());
        for (Lotto lotto : purchasedLottoDTO.getPurchasedLotto()) {
            System.out.println(Arrays.toString(lotto.getNumbers().toArray()));
        }
    }

    public static void printLottoResult(LottoResultDTO lottoResultDTO) {
        System.out.println(RESULT_MESSAGE.getMessage());
        System.out.println(SEPARATOR.getMessage());
        LottoRank[] ranks = LottoRank.values();
        for (int i = 4; i >= 0; i--) {
            LottoRank rank = ranks[i];
            int count = lottoResultDTO.getLottoResultInfo().getOrDefault(rank, 0);
            System.out.printf(LOTTO_RESULT_MESSAGE.getMessage(), rank.getWinningMessage(), rank.getMoney(), count);
        }
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println((exception.getMessage()));
    }

    public static void printProfit(Double userProfit) {
        System.out.println(PROFIT_MESSAGE.getMessage().formatted(userProfit));
    }
}

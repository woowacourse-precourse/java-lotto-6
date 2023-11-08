package lotto.view;

import java.util.Collections;
import lotto.domain.Lotto;
import lotto.domain.LottoGameResult;
import lotto.domain.LottoPlayer;
import lotto.enums.LottoRankEnum;
import lotto.enums.OutputMessageEnum;

public class OutputView {

    public void printPurchaseAmount(int amount) {
        System.out.println(OutputMessageEnum.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(amount));
    }

    public void printLotto(Lotto lotto) {
        System.out.println(OutputMessageEnum.OUTPUT_LOTTO_MESSAGE.getMessage(lotto));
    }

    public void printLottoGameResult(LottoPlayer lottoPlayer, LottoGameResult lottoGameResult) {
        int totalPrize = 0;
        for (LottoRankEnum lottoRankEnum : LottoRankEnum.values()) {
            if (lottoRankEnum == LottoRankEnum.NOTHING) {
                break;
            }
            int count = Collections.frequency(lottoGameResult.getLottoRanks(), lottoRankEnum);
            totalPrize += count * lottoRankEnum.getPrize();
            System.out.println(lottoRankEnum.getOutputMessageEnum().getMessage(lottoRankEnum.getPrize(), count));
        }

        System.out.println(OutputMessageEnum.OUTPUT_RESULT_END_MESSAGE.getMessage(
                (double) totalPrize / lottoPlayer.getPurchasePrice()));
    }
}

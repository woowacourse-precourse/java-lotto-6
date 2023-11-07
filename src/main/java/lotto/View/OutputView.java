package lotto.View;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.Constant.Constant;
import lotto.Domain.Lotties;
import lotto.Domain.Lotto;
import lotto.Domain.LottoRank;
import lotto.Domain.LottoResult;

public class OutputView {

    private static OutputView outputView = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return outputView;
    }

    public void showLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + Constant.OUTPUT_LOTTO_COUNT_MESSAGE);
    }

    public void showLotties(Lotties lotties) {
        for (Lotto lotto : lotties.getLotties()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showLottoResult(LottoResult lottoResult) {
        lottoResultIntro();
        Map<LottoRank, Integer> lottoResults = lottoResult.getLottoResult();
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.values());
        for (LottoRank lottoRank : lottoRanks) {
            if (lottoRank.equals(LottoRank.RAND_NONE)) {
                continue;
            }
            System.out.println(lottoRank.getMessage() + lottoResult.getLottoResult().get(lottoRank)
                    + Constant.OUTOUT_COUNT_MESSAGE);
        }
    }

    private void lottoResultIntro() {
        System.out.println();
        System.out.println(Constant.OUTPUT_LOTTO_RESULT_INTRO_MESSAGE);
        System.out.println(Constant.DIVIDE_LINE);
    }

}

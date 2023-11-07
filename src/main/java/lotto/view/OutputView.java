package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.enums.LottoRank;

import java.util.List;
import java.util.Map;

import static lotto.constant.OutputMessage.DIVIDE_LINE;
import static lotto.constant.OutputMessage.EARNING_RATE_END_MESSAGE;
import static lotto.constant.OutputMessage.EARNING_RATE_START_MESSAGE;
import static lotto.constant.OutputMessage.NEW_LINE;
import static lotto.constant.OutputMessage.PURCHASE_COUNT_MESSAGE;
import static lotto.constant.OutputMessage.RESULT_INTRO;
import static lotto.constant.OutputMessage.WIN_COUNT_MESSAGE;

public class OutputView {
    public static void showPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public static void showPurchaseLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static void showResultIntro() {
        System.out.println();
        System.out.println(RESULT_INTRO.getMessage());
        System.out.println(DIVIDE_LINE.getMessage());
    }

    public static void showResult(LottoResult lottoResult, long money) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<LottoRank, Integer> entry : getLottoResultEntry(lottoResult)) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            stringBuilder.append(rank.getMessage())
                    .append(count)
                    .append(WIN_COUNT_MESSAGE.getMessage())
                    .append(NEW_LINE.getMessage());
        }

        stringBuilder.append(EARNING_RATE_START_MESSAGE.getMessage())
                .append(String.format("%,.1f", lottoResult.getEarningRate(money)))
                .append(EARNING_RATE_END_MESSAGE.getMessage());
        System.out.println(stringBuilder);
    }

    private static List<Map.Entry<LottoRank, Integer>> getLottoResultEntry(LottoResult lottoResult) {
        return lottoResult.getLottoResult().entrySet()
                .stream()
                .filter(entry -> entry.getKey() != LottoRank.NONE)
                .toList();
    }
}

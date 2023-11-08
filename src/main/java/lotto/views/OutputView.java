package lotto.views;

import lotto.models.Lotto;
import lotto.models.LottoGrade;
import lotto.models.LottoResult;

import java.util.List;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.";
    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";

    public static void printPurchaseLottos(int lottoAmount, List<Lotto> lottos) {
        System.out.println(String.format(LOTTO_AMOUNT_MESSAGE, lottoAmount));
        for (Lotto lotto : lottos) {

            System.out.println(String.join(", ", lotto.getNumbers().toString()));
        }
    }

    public static void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);

        StringBuilder content = new StringBuilder();

        for (LottoGrade lottoGrade : LottoGrade.values()) {
            if (lottoGrade == LottoGrade.NONE) {
                continue;
            }

            content.append(lottoGrade.toString())
                    .append(" - ")
                    .append(lottoResult.getLottoResultAmount(lottoGrade))
                    .append("개\n");
        }

        content.append("총 수익률은 ")
                .append(lottoResult.calcProfitRate())
                .append("%입니다.");

        System.out.println(lottoResult.toString());
    }

}

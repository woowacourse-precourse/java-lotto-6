package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;

public class OutputView {

    public static void printLottos(int money, List<Lotto> lottos) {
        int lottoQuantity = money / 1000;
        System.out.println(lottoQuantity + "개를 구매했습니다.");

        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printLottoResult(Map<LottoResult, Integer> lottoMap) {
        System.out.println("당첨 통계\n"
                + "---");

        for (LottoResult lottoResult : lottoMap.keySet()) {
            StringBuilder stringBuilder = new StringBuilder(lottoResult.getCount());
            stringBuilder.append("개 일치");
            stringBuilder.append(" (");
            if (lottoResult.isValidBonus()) {
                stringBuilder.append(", 보너스 볼 일치");
            }
            stringBuilder.append(lottoResult.getPrize());
            stringBuilder.append("원) - ");
            stringBuilder.append(lottoMap.get(lottoResult));
            stringBuilder.append("개");
            System.out.println(stringBuilder);
        }
    }

}
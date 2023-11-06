package lotto.View;

import lotto.Enum.Prize;
import lotto.Lotto;

import java.util.Map;

public class OutputView {

    private static final String OUTPUT_VIEW_PURCHASE = "개를 구매했습니다.";

    public void purchaseLottoCount(int count) {
        System.out.println(count + OUTPUT_VIEW_PURCHASE);
    }

    public void LottoNumber(Lotto lotto) {
        System.out.println(lotto.getNumbers().toString());
    }

    public void LottoGameResult(Map<Prize, Integer> winResult) {
        System.out.println("당첨 통계\n---");
        for (Prize key : winResult.keySet()) {
            System.out.println(key.getTag() + " - " + winResult.get(key) + "개");
        }
    }

    public void totalRating(String rate) {
        System.out.println("총 수익률은 " + rate + "%입니다");
    }


}

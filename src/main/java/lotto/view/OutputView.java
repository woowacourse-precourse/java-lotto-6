package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.constant.Prize;
import lotto.model.LottoResult;

public class OutputView {

    public static void printPurchasedLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotto(List<Integer> lottoNumbers) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer num : lottoNumbers) {
            joiner.add(num.toString());
        }
        String result = joiner.toString();
        System.out.println(result);
    }

    public static void printTotalResult(LottoResult lottoResult, Double rateOfReturn) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(
            String.format("3개 일치 (5,000원) - %d개", lottoResult.getPrizeCount(Prize.FIFTH)));
        System.out.println(
            String.format("4개 일치 (50,000원) - %d개", lottoResult.getPrizeCount(Prize.FOURTH)));
        System.out.println(
            String.format("5개 일치 (1,500,000원) - %d개", lottoResult.getPrizeCount(Prize.THIRD)));
        System.out.println(String.format("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",
            lottoResult.getPrizeCount(Prize.SECOND)));
        System.out.println(
            String.format("6개 일치 (2,000,000,000원) - %d개", lottoResult.getPrizeCount(Prize.FIRST)));
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", rateOfReturn));
        System.out.println();

    }
}

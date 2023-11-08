package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Print {

    final static String priceRequest = "구입금액을 입력해 주세요.";
    final static String quantity = "%d개를 구매했습니다.";
    final static String lottoNumberRequest = "당첨 번호를 입력해 주세요.";
    final static String bonusNumberRequest = "보너스 번호를 입력해 주세요.";
    final static String winningAnalysis = "당첨 통계";
    final static String separatorLine = "---";
    final static String threeMatches = "3개 일치 (5,000원) - %d개";
    final static String fourMatches = "4개 일치 (50,000원) - %d개";
    final static String fiveMatches = "5개 일치 (1,500,000원) - %d개";
    final static String fiveMatchesWithBonus = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    final static String sixMatches = "6개 일치 (2,000,000,000원) - %d개";
    final static String totalReturnRate = "총 수익률은 %.1f%%입니다.";

    void lottoNumber(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            lotto.printNumbers();
        }
    }

    void analysis(int quantity, List<Prize> prizes) {
        List<Rank> ranks = new ArrayList<>();
        System.out.println("\n" + winningAnalysis);
        System.out.println(separatorLine);
        for (Prize prize : prizes) {
            ranks.add(prize.getRank());
        }
        System.out.printf((threeMatches) + "%n", Collections.frequency(ranks, Rank.FIFTH));
        System.out.printf((fourMatches) + "%n", Collections.frequency(ranks, Rank.FOURTH));
        System.out.printf((fiveMatches) + "%n", Collections.frequency(ranks, Rank.THIRD));
        System.out.printf((fiveMatchesWithBonus) + "%n", Collections.frequency(ranks, Rank.SECOND));
        System.out.printf((sixMatches) + "%n", Collections.frequency(ranks, Rank.FIRST));
        LottoFunction lottoFunction = new LottoFunction();
        System.out.println(lottoFunction.getEarningRate(quantity, prizes));

    }

}

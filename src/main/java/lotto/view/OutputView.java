package lotto.view;

import static lotto.util.util.println;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Rsult;

public class OutputView {
    public static String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";
    public static String WINNING_RESULT_MESSAGE = "당첨 통계\n---";

    public void printPurchaseQyantity(int quantity) {
        println(quantity + PURCHASE_QUANTITY_MESSAGE);
    }
    public void printwinningResultMessage() {
        println(WINNING_RESULT_MESSAGE);
    }

    public void printLottoNumbers(Lottos lottos) {
        println(numberForamat.makeFormat(lottos));
    }

    public String printResultFormat(List<Rank> ranks, int purchase) {
        return  "3개 일치 (5,000원) - " + matchResult(ranks,Rank.FIFTH) + "개\n"
        + "4개 일치 (50,000원) - " +  matchResult(ranks,Rank.FOURTH) + "개\n"
        + "5개 일치 (1,500,000원) - " +  matchResult(ranks,Rank.THIRD) + "개\n"
        +"5개 일치, 보너스 볼 일치 (30,000,000원) - " +  matchResult(ranks,Rank.SECOND) + "개\n"
        + "6개 일치 (2,000,000,000원) - " + matchResult(ranks,Rank.FIRST) + "개\n"
        + "총 수익률은 " + matchYeild(purchase, ranks) + "%입니다.";
    }
    public void printResult(List<Rank> ranks, int purchase) {
        println(printResultFormat(ranks, purchase));
    }

    public int matchResult(List<Rank> ranks, Object o) {
        return (int) ranks.stream()
                .filter(rank -> rank == o)
                .count();
    }
    public double matchYeild(int purchase, List<Rank> ranks ) {
        return Rsult.yield(purchase, ranks);
    }
}

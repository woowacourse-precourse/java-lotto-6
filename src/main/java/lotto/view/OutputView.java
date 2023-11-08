package lotto.view;

import static lotto.util.OutputMessage.CORRECT_FIVE;
import static lotto.util.OutputMessage.CORRECT_FIVE_AND_BONU;
import static lotto.util.OutputMessage.CORRECT_FOURE;
import static lotto.util.OutputMessage.CORRECT_SIX;
import static lotto.util.OutputMessage.CORRECT_THREE;
import static lotto.util.OutputMessage.GAE;
import static lotto.util.OutputMessage.IS_PERCENT;
import static lotto.util.OutputMessage.PURCHASE_QUANTITY_MESSAGE;
import static lotto.util.OutputMessage.TOTAL_RATE;
import static lotto.util.OutputMessage.WINNING_RESULT_MESSAGE;
import static lotto.util.util.println;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.Result;

public class OutputView {


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
        return  CORRECT_THREE + matchResult(ranks,Rank.FIFTH) + GAE
        + CORRECT_FOURE +  matchResult(ranks,Rank.FOURTH) + GAE
        + CORRECT_FIVE +  matchResult(ranks,Rank.THIRD) + GAE
        + CORRECT_FIVE_AND_BONU +  matchResult(ranks,Rank.SECOND) + GAE
        + CORRECT_SIX + matchResult(ranks,Rank.FIRST) + GAE
        + TOTAL_RATE + matchYeild(purchase, ranks) + IS_PERCENT;
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
        return Result.yield(purchase, ranks);
    }
}

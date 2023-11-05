package lotto.view;

import lotto.domain.Enum.Message;
import lotto.domain.Enum.Rank;

import java.util.Map;

public class OutputView {
    public void amountMessage() {
        System.out.println(Message.INPUT_AMOUNT_MESSAGE);
    }

    public void countMessage(int count) {
        System.out.println("\n" + count + "개를 구매했습니다.");
    }

    public void lottoNumberMessage(String lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void winningNumberMessage() {
        System.out.println(Message.INPUT_WINNINGLOTTO);
    }

    public void bonusNumberMessage() {
        System.out.println(Message.INPUT_BONUSNUMBER);
    }

    public void matchingMessage(Map<Rank, Integer> ranks, double rateOfReturn) {
        System.out.println(Message.RESULT);
        System.out.println(Message.RANKING_FIFTH.getMessage()+ "" + ranks.get(Rank.FIFTH) + "개");
        System.out.println(Message.RANKING_FORTH.getMessage()+ "" + ranks.get(Rank.FORTH) + "개");
        System.out.println(Message.RANKING_THIRD.getMessage() + "" + ranks.get(Rank.THIRD) + "개");
        System.out.println(Message.RANKING_SECOND.getMessage() + "" + ranks.get(Rank.SECOND) + "개");
        System.out.println(Message.RANKING_FIRST.getMessage() + "" + ranks.get(Rank.FIRST) + "개");

        System.out.println("총 수익률은 " + String.format("%.1f", rateOfReturn) + "%입니다.");
    }
}

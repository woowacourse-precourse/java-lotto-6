package lotto.view;

import lotto.domain.CompareResult;
import lotto.util.Rank;

public class OutputCompareLottoView {
    public void printCompareLotto(CompareResult compareResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = Rank.FIFTH.ordinal(); i >= Rank.FIRST.ordinal(); i--) {
            System.out.println(Rank.values()[i].getOutputMessage() + compareResult.getMatchingCounts()[i] + "개");
        }
    }

}

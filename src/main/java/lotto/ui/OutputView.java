package lotto.ui;

import lotto.Lotto;

import java.util.List;

import lotto.domain.Constants;
import lotto.domain.ResultMessage;

import static lotto.domain.Message.PURCHASE_COMMENT;

public class OutputView {
    public static void printLotto(List<Lotto> myLotto) {
        System.out.printf(PURCHASE_COMMENT.getMessage(), myLotto.size());
        for (Lotto lotto : myLotto) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public static void printStatistics(List<Integer> prizes, float profitPercent) {
        System.out.println(Constants.RESULT);
        for (ResultMessage result : ResultMessage.values()) {
            System.out.printf(result.getMessage(), prizes.get(result.ordinal()));
        }
        System.out.printf(Constants.PROFIT, profitPercent);
    }
}

package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Ranking;

import java.util.*;

public class OutputView {
    private static final String PURCHASED_QUANTITY_MESSAGE = "%d개를 구매했습니다.";
    private static final String WINNING_RESULT_TITLE_MESSAGE = "당첨 통계\n---";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %s%%입니다.";

    public static void printPurchasedQuantity(int quantity){
        System.out.printf(PURCHASED_QUANTITY_MESSAGE, quantity);
    }

    public static void printPurchasedLottos(List<Lotto> purchasedLottos){
        for(Lotto lotto : purchasedLottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningResult(HashMap<Ranking, Integer> winningResult){
        System.out.println(WINNING_RESULT_TITLE_MESSAGE);

        for (Ranking ranking : Ranking.getValues()){
            System.out.println(ranking.getMessage(winningResult.get(ranking)));
        }
    }

    public static void printRateOfReturn(String rateOfReturn){
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}

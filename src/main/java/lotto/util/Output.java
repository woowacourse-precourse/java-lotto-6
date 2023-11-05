package lotto.view;

import lotto.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.CommonMessages.*;

public class OutputView {

    public void printPurchaseAmount(Integer amount) {

        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {

        for (Lotto lotto : lottos) {

            String numbers = lotto.getNumbers().toString();
            System.out.println(String.join(", ", numbers));
        }
    }

    public void printResult(HashMap<Integer, Integer> result) {

        System.out.println();
        System.out.println(WINNING_RESULT.getMessage());
        System.out.println(MATCH_THREE.getMessage(result.get(3)));
        System.out.println(MATCH_FOUR.getMessage(result.get(4)));
        System.out.println(MATCH_FIVE.getMessage(result.get(5)));
        System.out.println(MATCH_FIVE_BONUS.getMessage(result.get(7)));
        System.out.println(MATCH_SIX.getMessage(result.get(6)));
        System.out.println(PROFIT_RATE.getMessage());
    }
}

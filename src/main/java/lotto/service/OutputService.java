package lotto.service;

import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.List;

import static lotto.CommonMessages.*;
import static lotto.MATCHING.*;
import static lotto.service.LottoService.*;

public class OutputService {


    public void printPurchaseAmount(Integer amount) {

        System.out.println();
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottoes) {

        for (Lotto lotto : lottoes) {

            String numbers = lotto.getNumbers().toString();
            System.out.println(String.join(", ", numbers));
        }
    }

    public void printResult(HashMap<Integer, Integer> result, double profit) {

        System.out.println();
        System.out.println(WINNING_RESULT.getMessage());
        System.out.println(MATCH_THREE.getMessage(result.get(ANSWER_COUNT_THREE)));
        System.out.println(MATCH_FOUR.getMessage(result.get(ANSWER_COUNT_FOUR)));
        System.out.println(MATCH_FIVE.getMessage(result.get(ANSWER_COUNT_FIVE)));
        System.out.println(MATCH_FIVE_BONUS.getMessage(result.get(ANSWER_COUNT_FIVE_BONUS)));
        System.out.println(MATCH_SIX.getMessage(result.get(ANSWER_COUNT_SIX)));
        System.out.println(PROFIT_RATE.getMessage(profit));
    }

    public void printError(IllegalArgumentException e) {

        System.out.println(e.getMessage());
    }
}

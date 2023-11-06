package lotto;

import java.util.ArrayList;
import java.util.List;

public class ResultService {
    public static int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / InputService.AMOUNT_UNIT;
    }

    public static void printNumberOfLottoTickets(int purchaseAmount) {
        System.out.printf("%d개를 구매했습니다.", purchaseAmount);
    }

    public static List<Lotto> getResultsOfLottoIssuance(int purchaseAmount) {
        List<Lotto> resultsOfLottoIssuance = new ArrayList<>();
        for (int i = 1; i <= purchaseAmount; i++) {
            resultsOfLottoIssuance.add(Lotto.createRandomNumbersForLotto());
        }
        return resultsOfLottoIssuance;
    }


}

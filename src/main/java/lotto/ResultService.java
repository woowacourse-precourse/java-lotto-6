package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultService {
    public static int calculateNumberOfLottoTickets(int purchaseAmount) {
        return purchaseAmount / InputService.AMOUNT_UNIT;
    }

    public static void printNumberOfLottoTickets(int purchaseNumber) {
        System.out.printf("%d개를 구매했습니다.", purchaseNumber);
    }

    public static List<Lotto> getResultsOfLottoIssuance(int purchaseNumber) {
        List<Lotto> resultsOfLottoIssuance = new ArrayList<>();
        for (int i = 1; i <= purchaseNumber; i++) {
            resultsOfLottoIssuance.add(Lotto.createRandomNumbersForLotto());
        }
        return resultsOfLottoIssuance;
    }

    public static void printResultsOfLottoIssuance(List<Lotto> resultOfLottoIssuance) {
        for (Lotto result : resultOfLottoIssuance) {
            printSortResult(result);
        }
    }

    private static void printSortResult(Lotto result) {
        List<Integer> sortResult = result.sortNumbers(result);
        System.out.println(sortResult);
    }


}

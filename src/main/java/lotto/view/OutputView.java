package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class OutputView {

    private static final String RATE_OF_RETURN = "총 수익률은 %2.f%% 입니다.";
    private static final String PURCHASE_QUANTITY = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String LOTTO_RESULT = """
            ---
            3개 일치 (5,000원) - %d개
            4개 일치 (50,000원) - %d개
            5개 일치 (1,500,000원) - %d개
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
            6개 일치 (2,000,000,000원) - %d개
            """;

    public void printPurchaseQuantity(int quantity) {
        System.out.println(String.format(PURCHASE_QUANTITY, quantity));
    }

    public void printRandomLottos(List<Lotto> lottos) {
        List<List<Integer>> sortedLottoNumbers = IntStream.range(0, lottos.size())
                .mapToObj(index -> new ArrayList<>(lottos.get(index).getNumbers()))
                .peek(Collections::sort)
                .collect(Collectors.toList());

        sortedLottoNumbers.forEach(System.out::println);

    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.println(String.format(RATE_OF_RETURN, rateOfReturn));
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public void printLottoResult() {
        System.out.println(String.format(LOTTO_RESULT));
    }
}

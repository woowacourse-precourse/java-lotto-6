package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoView {

    private static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %,.1f%%입니다.";
    private static final String PRINT_RESULT_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private static final String SECOND_UNIQUE_MESSAGE = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";

    public void printLotto(List<Lotto> lottoTickets) {
        System.out.println(PURCHASE_MESSAGE.formatted(lottoTickets.size()));

        lottoTickets.stream()
                .map(Lotto::toString)
                .forEach(System.out::println);
    }

    public void printResult(Map<Rank, Integer> checkResult, double rateOfReturn) {
        printLottoResult(checkResult);
        System.out.println(printRate(rateOfReturn));
    }

    private void printLottoResult(Map<Rank, Integer> checkResult) {
        checkResult.forEach((rank, integer) -> {
            if(rank.equals(Rank.SECOND)){
                String format = String.format(SECOND_UNIQUE_MESSAGE, rank.matchedCount, rank.reward, integer);
                System.out.println(format);
                return;
            }
            String format = String.format(PRINT_RESULT_MESSAGE, rank.matchedCount, rank.reward, integer);
            System.out.println(format);
        });
    }

    public String printRate(double rate) {
        return String.format(RATE_OF_RETURN_MESSAGE,rate);
    }
}

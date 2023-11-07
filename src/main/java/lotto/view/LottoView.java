package lotto.view;

import static lotto.view.LottoView.Message.PRINT_RESULT;
import static lotto.view.LottoView.Message.PURCHASE;
import static lotto.view.LottoView.Message.RATE_OF_RETURN;
import static lotto.view.LottoView.Message.SECOND_UNIQUE;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class LottoView {
    enum Message {
        PURCHASE("%d개를 구매했습니다."),
        RATE_OF_RETURN("총 수익률은 %,.1f%%입니다."),
        PRINT_RESULT("%d개 일치 (%,d원) - %d개"),
        SECOND_UNIQUE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개");
        String template;

        Message(String template) {
            this.template = template;
        }
    }

    public void printLotto(List<Lotto> lottoTickets) {
        String format = String.format(PURCHASE.template, lottoTickets.size());
        System.out.println(format);

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
            if (rank.equals(Rank.SECOND)) {
                String format = String.format(SECOND_UNIQUE.template, rank.matchedCount, rank.reward, integer);
                System.out.println(format);
                return;
            }
            String format = String.format(PRINT_RESULT.template, rank.matchedCount, rank.reward, integer);
            System.out.println(format);
        });
    }

    public String printRate(double rate) {
        return String.format(RATE_OF_RETURN.template, rate);
    }
}

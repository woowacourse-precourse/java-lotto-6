package lotto.ui;

import java.util.Arrays;
import lotto.domain.LottoTicket;
import lotto.dto.WinningResult;
import lotto.enums.Prize;
import lotto.util.Converter;

public class OutputView {
    public void printError(final String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoTicket(final LottoTicket lottoTicket) {
        System.out.printf("%d개를 구매했습니다.%n", lottoTicket.count());
        lottoTicket.lottoTicket().forEach(System.out::println);
        System.out.println();
    }

    public void printWinningResult(final WinningResult winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(Prize.PRIZES)
                .filter(prize -> prize != Prize.NONE)
                .forEach(p -> System.out.printf(getFormat(p),
                        p.getMatchedCount(), Converter.convertNumberWithComma(p.getWinningMoney()), winningResult.countOf(p)));
    } // TODO 수정

    private String getFormat(final Prize prize) {
        if (prize == Prize.SECOND) {
            return "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";
        }
        return "%d개 일치 (%s원) - %d개%n";
    } // TODO 수정

    public void printYield(final String yield) {
        System.out.printf("총 수익률은 %s%%입니다.%n", yield);
    }
    // TODO enum
}

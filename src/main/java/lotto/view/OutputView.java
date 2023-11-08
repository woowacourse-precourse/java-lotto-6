package lotto.view;

import lotto.domain.dto.output.DrawLottosResponse;
import lotto.domain.dto.output.LottoResponse;
import lotto.domain.dto.output.LottosResponse;
import lotto.io.Writer;

import java.util.List;

public class OutputView {
    private static final String QUANTITY_MSG = "\n%d개를 구매했습니다.";
    private static final String STATISTIC_MSG = "\n당첨 통계\n" + "---";
    private static final String STATISTIC_FORMAT = "3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개\n" +
            "총 수익률은 %.1f%%입니다.";
    private final Writer writer;

    public OutputView(Writer writer) {
        this.writer = writer;
    }

    private static String getQuantity(LottosResponse lottosResponse) {
        return String.format(QUANTITY_MSG, lottosResponse.quantity());
    }

    private static String getNumbers(LottoResponse lottoTicket) {
        return lottoTicket.numbers()
                .toString();
    }

    public void printPurchasedLotto(LottosResponse lottosResponse) {
        writer.writeln(getQuantity(lottosResponse));
        List<LottoResponse> lottoTickets = lottosResponse.lottoNumbers();
        for (LottoResponse lottoTicket : lottoTickets) {
            writer.writeln(getNumbers(lottoTicket));
        }
    }

    public void printDrawResult(DrawLottosResponse drawLottosResponse) {
        writer.writeln(STATISTIC_MSG);
        writer.writeln(String.format(
                STATISTIC_FORMAT,
                drawLottosResponse.fifth(),
                drawLottosResponse.fourth(),
                drawLottosResponse.third(),
                drawLottosResponse.second(),
                drawLottosResponse.first(),
                drawLottosResponse.rateOfReturn()));
    }
}


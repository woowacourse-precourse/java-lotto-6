package lotto.view;

import lotto.domain.dto.output.DrawLottoDto;
import lotto.domain.dto.output.LottoDto;
import lotto.domain.dto.output.LottosDto;
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

    private static String getQuantity(LottosDto lottosDto) {
        return String.format(QUANTITY_MSG, lottosDto.quantity());
    }

    private static String getNumbers(LottoDto lottoDto) {
        return lottoDto.numbers()
                .toString();
    }

    public void printPurchasedLotto(LottosDto lottosDto) {
        writer.writeln(getQuantity(lottosDto));
        List<LottoDto> lottoTickets = lottosDto.lottoNumbers();
        for (LottoDto lottoTicket : lottoTickets) {
            writer.writeln(lottoTicket.numbers().toString());
        }
    }


    public void printDrawResult(DrawLottoDto drawLottoDto) {
        writer.writeln(STATISTIC_MSG);
        writer.writeln(String.format(
                STATISTIC_FORMAT,
                drawLottoDto.fifth(),
                drawLottoDto.fourth(),
                drawLottoDto.third(),
                drawLottoDto.second(),
                drawLottoDto.first(),
                drawLottoDto.rateOfReturn()));
    }
}


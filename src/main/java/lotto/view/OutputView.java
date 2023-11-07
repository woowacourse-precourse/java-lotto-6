package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.output.DrawingResultDto;
import lotto.dto.output.LottoDto;
import lotto.dto.output.LottosDto;
import lotto.io.output.StdWriter;
import lotto.io.output.Writer;

public class OutputView {
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String TEMPLATE = """
             
                    당첨 통계
                    ---
                    3개 일치 (5,000원) - %d개
                    4개 일치 (50,000원) - %d개
                    5개 일치 (1,500,000원) - %d개
                    5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
                    6개 일치 (2,000,000,000원) - %d개
                    총 수익률은 %s%%입니다.
            """.replaceAll("( ){2,}", "");
    private static final String NUMBER_FORMAT_PATTERN = "###,###.0";
    private static final double ZERO_PROFIT_RATE = 0.0;
    private static final String ZERO_PROFIT_RATE_STRING = "0.0";
    private final StdWriter writer;

    public OutputView(StdWriter writer) {
        this.writer = writer;
    }

    public void printPurchasedLottoTickets(LottosDto lottosDto) {
        List<LottoDto> lottoTickets = lottosDto.lottos();
        printLottoTicketsCount(lottoTickets);
        printAllLottoTickets(lottoTickets);
    }

    private void printLottoTicketsCount(List<LottoDto> lottoTickets) {
        String message = String.format("%s%d개를 구매했습니다.", Writer.NEW_LINE, lottoTickets.size());
        writer.writeLine(message);
    }

    private void printAllLottoTickets(List<LottoDto> lottoTickets) {
        lottoTickets.stream()
                .map(lottoTicket -> formatLottoNumbers(lottoTicket.lottoNumbers()))
                .forEach(writer::writeLine);
        writer.write(Writer.NEW_LINE);
    }

    private String formatLottoNumbers(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
    }

    public void printResult(DrawingResultDto drawingResult) {
        String message = String.format(
                TEMPLATE,
                drawingResult.fifthMatchCount(),
                drawingResult.fourthMatchCount(),
                drawingResult.thirdMatchCount(),
                drawingResult.secondMatchCount(),
                drawingResult.firstMatchCount(),
                getFormattedProfitOfRate(drawingResult)
        );
        writer.writeLine(message);
    }

    private String getFormattedProfitOfRate(DrawingResultDto drawingResult) {
        if (drawingResult.prizeOfRate() == ZERO_PROFIT_RATE) {
            return ZERO_PROFIT_RATE_STRING;
        }
        return formatPrizeOfRate(drawingResult);
    }

    private String formatPrizeOfRate(DrawingResultDto drawingResult) {
        DecimalFormat df = new DecimalFormat(NUMBER_FORMAT_PATTERN);
        return df.format(drawingResult.prizeOfRate());
    }
}


package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.output.DrawingResultDto;
import lotto.dto.output.LottoDto;
import lotto.dto.output.LottosDto;
import lotto.io.output.StdWriter;
import lotto.io.output.Writer;
import lotto.util.ViewConstants;

public class OutputView {
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
                .collect(Collectors.joining(ViewConstants.DELIMITER, ViewConstants.PREFIX, ViewConstants.SUFFIX));
    }

    public void printResult(DrawingResultDto drawingResult) {
        String message = String.format(
                ViewConstants.TEMPLATE,
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
        if (drawingResult.prizeOfRate() == ViewConstants.ZERO_PROFIT_RATE) {
            return ViewConstants.ZERO_PROFIT_RATE_STRING;
        }
        return formatPrizeOfRate(drawingResult);
    }

    private String formatPrizeOfRate(DrawingResultDto drawingResult) {
        DecimalFormat df = new DecimalFormat(ViewConstants.NUMBER_FORMAT_PATTERN);
        return df.format(drawingResult.prizeOfRate());
    }
}


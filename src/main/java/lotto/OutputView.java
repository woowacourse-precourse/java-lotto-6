package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.config.LottoGameMessage;

public class OutputView {

    private final OutputWriter outputWriter;
    private static final String DELIMITER = ", " ;

    public OutputView(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void printPurchasedLottos(LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.numbers();
        Collections.sort(numbers);
        outputWriter.writeLine(String.join(DELIMITER, numbers.toString()));
    }

    public void printPurchasedLottoSize(int purchased) {
        outputWriter.writeLine(purchased + LottoGameMessage.OUTPUT_PURCHASED_LOTTO_SIZE.message());
    }

    public void printWinningResults(LottoResultDto resultDto) {
        outputWriter.writeLine(LottoGameMessage.OUTPUT_WINNING_RESULTS.message());
        outputWriter.writeLine(LottoGameMessage.OUTPUT_WINNING_RESULTS_LINES.message());

        Map<Rank, Integer> result = resultDto.getResult();
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::prize))
                .forEach(rank -> outputWriter.writeLineWithoutNewLine(
                        createRankMessage(rank, result.get(rank))));
    }

    private String createRankMessage(final Rank rank, final int count) {
        if (rank == Rank.MISS) {
            return "";
        }
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%d원) - %d개\n",
                    rank.getMatched(), rank.prize(), count);
        }
        return String.format("%d개 일치 (%d원) - %d개\n",
                rank.getMatched(), rank.prize(), count);
    }
}
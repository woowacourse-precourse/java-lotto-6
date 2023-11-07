package lotto.view;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lotto.domain.dto.LottoDto;
import lotto.domain.dto.LottoResultDto;
import lotto.domain.Rank;
import lotto.config.LottoGameMessage;
import lotto.io.OutputWriter;

public class OutputView {

    private static final String DELIMITER = ", " ;
    private final OutputWriter outputWriter;

    public OutputView(OutputWriter outputWriter) {
        this.outputWriter = outputWriter;
    }

    public void printPurchasedLottos(final LottoDto lottoDto) {
        List<Integer> numbers = lottoDto.numbers();
        Collections.sort(numbers);
        outputWriter.writeLine(String.join(DELIMITER, numbers.toString()));
    }

    public void printPurchasedLottoSize(final int purchased) {
        outputWriter.writeLine(
                LottoGameMessage.OUTPUT_PURCHASED_LOTTO_SIZE.message().formatted(purchased));
    }

    public void printWinningResults(final LottoResultDto resultDto) {
        outputWriter.writeLine(LottoGameMessage.OUTPUT_WINNING_RESULTS.message());
        outputWriter.writeLine(LottoGameMessage.OUTPUT_WINNING_RESULTS_LINES.message());

        Map<Rank, Integer> result = resultDto.getResult();
        Arrays.stream(Rank.values())
                .sorted(Comparator.comparing(Rank::prize))
                .filter(rank -> rank != Rank.MISS)
                .forEach(rank -> outputWriter.writeLine(createRankMessage(rank, result.get(rank))));
    }

    private String createRankMessage(final Rank rank, final int count) {
        if (rank == Rank.SECOND) {
            return LottoGameMessage.OUTPUT_MATCHED_BONUS_NUMBER.message().
                    formatted(rank.getMatched(), formattedAmount(rank.prize()), count);
        }
        return LottoGameMessage.OUTPUT_MATCHED.message().
                formatted(rank.getMatched(), formattedAmount(rank.prize()), count);
    }

    public void printProfitRate(final double profitRate) {
        outputWriter.writeLine(LottoGameMessage.OUTPUT_PROFIT_RATE.message().formatted(profitRate));
    }

    private String formattedAmount(final long amount) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        return numberFormat.format(amount);
    }
}
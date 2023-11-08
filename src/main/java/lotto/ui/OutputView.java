package lotto.ui;

import static lotto.contents.ContentNumbers.ZERO;
import static lotto.contents.ContentStrings.OUTPUT_DASH;
import static lotto.contents.ContentStrings.OUTPUT_PURCHASED_LOTTO;
import static lotto.contents.ContentStrings.OUTPUT_RATE_PREFIX;
import static lotto.contents.ContentStrings.OUTPUT_RATE_SUFFIX;
import static lotto.contents.ContentStrings.OUTPUT_SPACE;
import static lotto.contents.ContentStrings.OUTPUT_WINNING_STATISTICS;
import static lotto.contents.ContentStrings.PERCENTAGE_FORMAT;

import java.util.List;
import java.util.Map;
import lotto.contents.ContentResults;
import lotto.domain.Prize;
import lotto.dto.LottoDto;

public class OutputView {
    public void printLottos(List<LottoDto> lottos) {
        System.out.println(OUTPUT_SPACE.getValue() + lottos.size() + OUTPUT_PURCHASED_LOTTO.getValue());
        lottos.stream()
                .forEach(this::printLottoNumbers);
    }

    private void printLottoNumbers(LottoDto lotto) {
        List<Integer> sortedNumbers = lotto.numbers().stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);
    }

    public static void printPrizeResults(Map<Prize, Integer> prizeCount) {
        System.out.println(OUTPUT_WINNING_STATISTICS.getValue());
        System.out.println(OUTPUT_DASH.getValue());

        for (Prize prize : Prize.values()) {
            if (prize != Prize.NONE) {
                int count = prizeCount.getOrDefault(prize, ZERO.getNumber());
                System.out.println(ContentResults.valueOf(prize.name()).getResultMessage(count));
            }
        }
    }

    public static void printEarningsRate(double earningsRate) {
        System.out.println(OUTPUT_RATE_PREFIX.getValue() +
                String.format(PERCENTAGE_FORMAT.getValue(), earningsRate) +
                OUTPUT_RATE_SUFFIX.getValue());
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }
}
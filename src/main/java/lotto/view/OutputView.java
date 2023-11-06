package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.util.enums.LottoRank;

public class OutputView {
    private static final String DIGIT_COMMA_WITH_BLANK = ", ";
    private static final OutputView instance = new OutputView();

    public static OutputView getInstance() {
        return instance;
    }

    public void outputLottoNumbers(List<Lotto> lotties) {
        System.out.printf(Message.OUTPUT_COMPLETE_BUY_LOTTO.message, lotties.size());
        for (Lotto lotto : lotties) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.printf(Message.OUTPUT_LOTTO_NUMBERS.message, formatter(numbers));
        }
    }

    public void outputLottoResults(List<LottoRank> rankResults) {
        System.out.printf(Message.OUTPUT_LOTTO_RESULTS.message);

        printRankCount(rankResults, LottoRank.FIFTH);
        printRankCount(rankResults, LottoRank.FOURTH);
        printRankCount(rankResults, LottoRank.THIRD);
        printRankCount(rankResults, LottoRank.SECOND);
        printRankCount(rankResults, LottoRank.FIRST);
    }

    private static void printRankCount(List<LottoRank> rankResults, LottoRank rank) {
        int count = Collections.frequency(rankResults, rank);
        System.out.printf(rank.getContent()
                + Message.OUTPUT_LOTTO_RESULT_COUNT.message, count);
    }

    private String formatter(List<Integer> numbers) {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DIGIT_COMMA_WITH_BLANK));
    }

    private enum Message {
        OUTPUT_COMPLETE_BUY_LOTTO("\n%s개를 구매했습니다.\n"),
        OUTPUT_LOTTO_NUMBERS("[%s]\n"),
        OUTPUT_LOTTO_RESULTS("\n당첨 통계\n---\n"),
        OUTPUT_LOTTO_RESULT_COUNT(" - %d개\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}

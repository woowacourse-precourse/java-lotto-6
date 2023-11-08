package lotto.view;

import static lotto.enums.ViewMessageType.OUTPUT_LOTTO_COUNT;
import static lotto.enums.ViewMessageType.OUTPUT_LOTTO_NUMBERS;
import static lotto.enums.ViewMessageType.OUTPUT_WINNING_STATISTIC;
import static lotto.enums.WinningRankType.FIFTH_PLACE;
import static lotto.enums.WinningRankType.FIRST_PLACE;
import static lotto.enums.WinningRankType.FOURTH_PLACE;
import static lotto.enums.WinningRankType.SECOND_PLACE;
import static lotto.enums.WinningRankType.THIRD_PLACE;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;

public class OutputView {
    private static final String DELIMITER = ", ";

    public static void printBuyLottoCount(int lottoCount) {
        System.out.printf(OUTPUT_LOTTO_COUNT.getMessage(), lottoCount);
    }

    public static void printLottoNumbers(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            String lottoNumbers = String.join(
                        DELIMITER, lotto.getNumbers()
                                        .stream()
                                        .map(String::valueOf)
                                        .toList()
                    );
            System.out.printf(OUTPUT_LOTTO_NUMBERS.getMessage(), lottoNumbers);
        }
    }

    public static void printWinningStatic(WinningResult winningResult, double rateOfReturn) {
        System.out.printf(
                OUTPUT_WINNING_STATISTIC.getMessage(),
                winningResult.getResult().getOrDefault(FIFTH_PLACE, 0),
                winningResult.getResult().getOrDefault(FOURTH_PLACE, 0),
                winningResult.getResult().getOrDefault(THIRD_PLACE, 0),
                winningResult.getResult().getOrDefault(SECOND_PLACE, 0),
                winningResult.getResult().getOrDefault(FIRST_PLACE, 0),
                rateOfReturn
        );
    }
}

package lotto.formatter;

import java.util.Arrays;
import lotto.constant.ProgressMessage;
import lotto.constant.WinningGrade;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningResult;

import java.util.stream.Collectors;

public class OutputFormatter {

    private static final String NEW_LINE = "\n";

    public String formatLottos(final Lottos lottos) {
        return lottos.toElements().stream()
                .map(Lotto::toValue)
                .map(list -> list.toString())
                .collect(Collectors.joining(NEW_LINE));
    }

    public String formatWinningResult(final WinningResult winningResult) {
        return Arrays.stream(WinningGrade.values())
                .map(
                        winningGrade ->
                                String.format(
                                        ProgressMessage.WINNING_RESULT.toValue(),
                                        winningGrade.toMatchNum(),
                                        winningGrade.toPrize(),
                                        winningResult.numOfWinningGrade(winningGrade)))
                .collect(Collectors.joining(NEW_LINE));
    }
}

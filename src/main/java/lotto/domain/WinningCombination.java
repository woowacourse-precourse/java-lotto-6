package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class WinningCombination {

    private static final int START_INDEX = 0;
    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningCombination(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult calculateWinningLottos(final Lottos lottos) {
        final List<WinningGrade> winningGrades = winningNumbers.compare(lottos);

        return IntStream.range(START_INDEX, winningGrades.size())
                .mapToObj(index -> mapToProperWinningGrade(lottos, index, winningGrades))
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        Function.identity(),
                                        winningGrade -> numOfValues(winningGrade, winningGrades)),
                                WinningResult::new));
    }

    private WinningGrade mapToProperWinningGrade(
            final Lottos lottos, final int index, final List<WinningGrade> winningGrades) {
        final WinningGrade winningGrade = winningGrades.get(index);
        return getProperWinningGrade(lottos, index, winningGrade);
    }

    private WinningGrade getProperWinningGrade(
            final Lottos lottos, final int index, final WinningGrade winningGrade) {
        if (winningGrade.isPossibleSecondWinner()) {
            return bonusNumber.checkSecondWinning(lottos.getByIndex(index));
        }
        return winningGrade;
    }

    private Integer numOfValues(
            final WinningGrade winningGrade, final List<WinningGrade> winningGrades) {
        final long count = winningGrades.stream().filter(winningGrade::equals).count();
        return Long.valueOf(count).intValue();
    }
}

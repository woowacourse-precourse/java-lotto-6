package lotto.domain;

import lotto.constant.ProgressMessage;
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
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final WinningNumbers winningNumbers, final BonusNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ProgressMessage.BONUS_NUMBER_ALREADY_EXISTS.toValue());
        }
    }

    public WinningResult calculateWinningLottos(final Lottos lottos) {
        final List<WinningGrade> winningGrades = winningNumbers.compare(lottos);
        final List<WinningGrade> result = checkSecondWinning(lottos, winningGrades);

        return mapToWinningResult(result);
    }

    private List<WinningGrade> checkSecondWinning(
            final Lottos lottos, final List<WinningGrade> winningGrades) {
        return IntStream.range(START_INDEX, winningGrades.size())
                .mapToObj(
                        index ->
                                checkBonusNumber(
                                        lottos.getByIndex(index), winningGrades.get(index)))
                .toList();
    }

    private WinningGrade checkBonusNumber(final Lotto lotto, final WinningGrade winningGrade) {
        if (winningGrade.isPossibleSecondWinner()) {
            return bonusNumber.checkSecondWinning(lotto);
        }
        return winningGrade;
    }

    private WinningResult mapToWinningResult(final List<WinningGrade> winningGrades) {
        return winningGrades.stream()
                .distinct()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap(
                                        Function.identity(),
                                        winningGrade -> numOfValues(winningGrade, winningGrades)),
                                WinningResult::new));
    }

    private Integer numOfValues(
            final WinningGrade winningGrade, final List<WinningGrade> winningGrades) {
        final long count = winningGrades.stream().filter(winningGrade::hasEqualValue).count();
        return Long.valueOf(count).intValue();
    }
}

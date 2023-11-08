package lotto.domain;

import lotto.constant.WinningGrade;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class WinningDetails {

    private final List<WinningDetail> values;

    public WinningDetails(final List<WinningDetail> values) {
        this.values = List.copyOf(values);
    }

    public int numOfValues() {
        return values.size();
    }

    public WinningDetail getByIndex(final int index) {
        return values.get(index);
    }

    public WinningResult toWinningResult() {
        return values.stream()
                .map(WinningDetail::toWinningGrade)
                .distinct()
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toMap(Function.identity(), this::numOfEqualValues),
                                WinningResult::new));
    }

    private Integer numOfEqualValues(final WinningGrade winningGrade) {
        final Long count =
                values.stream()
                        .map(WinningDetail::toWinningGrade)
                        .filter(winningGrade::hasEqualValue)
                        .count();

        return count.intValue();
    }
}

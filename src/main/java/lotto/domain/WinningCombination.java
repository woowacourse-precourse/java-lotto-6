package lotto.domain;

import lotto.constant.ProgressMessage;

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
        final WinningDetails winningDetails = winningNumbers.compare(lottos);
        final WinningDetails result = checkSecondWinning(lottos, winningDetails);

        return result.toWinningResult();
    }

    private WinningDetails checkSecondWinning(
            final Lottos lottos, final WinningDetails winningDetails) {

        return IntStream.range(START_INDEX, winningDetails.numOfValues())
                .mapToObj(index -> convertIfSecondWinning(lottos, winningDetails.getByIndex(index)))
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningDetails::new));
    }

    private WinningDetail convertIfSecondWinning(
            final Lottos lottos, final WinningDetail winningDetail) {

        return winningDetail.convertIfSecondWinning(
                lottos.getByWinningDetail(winningDetail), bonusNumber);
    }
}

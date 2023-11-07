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
                .mapToObj(index -> convertIfSecondWinning(lottos, winningDetails, index))
                .collect(Collectors.collectingAndThen(Collectors.toList(), WinningDetails::new));
    }

    private WinningDetail convertIfSecondWinning(
            final Lottos lottos, final WinningDetails winningDetails, final int index) {
        final WinningDetail winningDetail = winningDetails.getByIndex(index);
        return checkBonusNumber(lottos.getByWinningDetail(winningDetail), winningDetail);
    }

    private WinningDetail checkBonusNumber(final Lotto lotto, final WinningDetail winningDetail) {
        if (winningDetail.isPossibleSecondWinner()) {
            return new WinningDetail(
                    bonusNumber.checkSecondWinning(lotto), winningDetail.toIndex());
        }
        return winningDetail;
    }
}

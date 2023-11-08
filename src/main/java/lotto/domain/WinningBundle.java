package lotto.domain;

import lotto.constants.WinningBundleErrorMessage;
import lotto.dto.WinningBundleDto;

import java.util.List;
import java.util.stream.Collectors;

public class WinningBundle {

    private static final String WINNING_NUMBER_DUPLICATE_MESSAGE = "[ERROR] 당첨 번호는 중복되지 않아야 합니다.";
    private static final int WINNING_NUMBER_MAX_SIZE = 6;

    private final List<WinningNumber> winningBundle;

    private WinningBundle(List<WinningNumber> winningBundle) {
        this.winningBundle = winningBundle;
    }

    public static WinningBundle from(List<WinningNumber> winningBundle) {
        validateSize(winningBundle);
        validateDuplication(winningBundle);
        return new WinningBundle(winningBundle);
    }

    private static void validateSize(List<WinningNumber> winningBundle) {
        if (winningBundle.size() != WINNING_NUMBER_MAX_SIZE) {
            throw new IllegalArgumentException(WinningBundleErrorMessage.TOTAL_SIZE_INVALID.entireMessage());
        }
    }

    private static void validateDuplication(List<WinningNumber> winningBundle) {
        long duplication = winningBundle.stream()
                .distinct()
                .count();

        if (isLessThanWinningBundleSize(winningBundle, duplication)) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_MESSAGE);
        }
    }

    private static boolean isLessThanWinningBundleSize(List<WinningNumber> winningBundle, long duplication) {
        return duplication < winningBundle.size();
    }


    public List<Integer> getWinningBundle() {
        return this.winningBundle.stream()
                .map(WinningNumber::toInt)
                .collect(Collectors.toList());
    }

    public WinningBundleDto getWinningBundleDto() {
        return WinningBundleDto.from(getWinningBundle());
    }

    private boolean isContainsBonus(int bonusNumber) {
        return winningBundle.stream()
                .anyMatch(winningNumber -> winningNumber.isEqualsBonusNumber(bonusNumber));
    }

}

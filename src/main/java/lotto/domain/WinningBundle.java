package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningBundle {
    private static final String WINNING_NUMBER_MUST_TOTAL_SIX_MESSAGE = "[ERROR] 당첨 번호의 갯수는 총 6개여야 합니다.";
    private static final String WINNING_BUNDLE_CONTAIN_BONUS_NUMBER_MESSAGE = "[ERROR] 당첨 번호와 보너스 번호는 일치할 수 없습니다.";

    private final List<WinningNumber> winningBundle;

    private WinningBundle(List<WinningNumber> winningBundle) {
        this.winningBundle = winningBundle;
    }

    public static WinningBundle from(List<WinningNumber> winningBundle) {
        validateSize(winningBundle);
        return new WinningBundle(winningBundle);
    }

    private static void validateSize(List<WinningNumber> winningBundle) {
        if (winningBundle.size() != 6) {
            throw new IllegalArgumentException(WINNING_NUMBER_MUST_TOTAL_SIX_MESSAGE);
        }
    }

    public List<Integer> getWinningBundle() {
        return this.winningBundle.stream()
                .map(WinningNumber::toInt)
                .collect(Collectors.toList());
    }

    public void validateContainsBonusNumber(int bonusNumber) {
        if (isContainsBonus(bonusNumber)) {
            throw new IllegalArgumentException(WINNING_BUNDLE_CONTAIN_BONUS_NUMBER_MESSAGE);
        }
    }

    private boolean isContainsBonus(int bonusNumber) {
        return winningBundle.stream()
                .anyMatch(winningNumber -> winningNumber.isEqualsBonusNumber(bonusNumber));
    }

}

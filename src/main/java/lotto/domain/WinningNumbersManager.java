package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningNumbersManager {
    private static final String BONUS_NUMBER_NOT_OVERLAP_WITH_WINNING_NUMBERS = "보너스 번호는 당첨 번호와 중복되면 안됩니다";

    private List<Integer> winningNumbers;
    private int bonusNumber;

    void inputWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public void validateBonusNumber(Integer invalidBonusNumber) {
        for (Integer number : winningNumbers) {
            if (number.equals(invalidBonusNumber)) {
                throw new IllegalArgumentException(BONUS_NUMBER_NOT_OVERLAP_WITH_WINNING_NUMBERS);
            }
        }
    }

    public void inputBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public Map<WinningStatus, Integer> getWinningStatus(List<Lotto> lottos) {
        Map<WinningStatus, Integer> winningStatus = getInitStatus();

        for (Lotto lotto : lottos) {
            WinningStatus status = getWinningStatus(lotto);
            if (status != null) {
                winningStatus.put(status, winningStatus.get(status) + 1);
            }
        }

        return winningStatus;
    }

    private WinningStatus getWinningStatus(Lotto lotto) {
        int matchCount = lotto.getMatchCount(winningNumbers);
        boolean isBonusMatch = false;

        if (matchCount == 5 && lotto.isMatch(bonusNumber)) {
            isBonusMatch = true;
        }

        return WinningStatus.valueOfMatchCount(matchCount, isBonusMatch);
    }

    private Map<WinningStatus, Integer> getInitStatus() {
        Map<WinningStatus, Integer> winningStatus = new HashMap<>();
        for (WinningStatus status : WinningStatus.values()) {
            winningStatus.put(status, 0);
        }

        return winningStatus;
    }
}

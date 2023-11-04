package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        validateNoDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private Map<WinningStatistics, Integer> initMapWinningStatistics() {
        Map<WinningStatistics, Integer> statistics = new EnumMap<>(WinningStatistics.class);
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value, 0);
        }
        return statistics;
    }

    private void validateNoDuplicate(BonusNumber bonusNumber) {
        if (isDuplicateWinningLottoNumberAndBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private boolean isDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        return winningLotto.LottoContainsNumber(bonusNumber.getBonusNumber());
    }
}

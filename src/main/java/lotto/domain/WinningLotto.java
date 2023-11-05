package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        validateDuplicateWinningLottoNumberAndBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult calculateStatistics(BuyerLotto buyerLotto) {
        Map<WinningStatistics, Integer> statistics = initMapWinningStatistics();
        for (Lotto lottoNumber : buyerLotto.getBuyerLotto()) {
            WinningStatistics winningStatistics = lottoNumber.containsLotto(winningLotto, bonusNumber);
            statistics.put(winningStatistics, statistics.getOrDefault(winningStatistics, 0) + 1);
        }
        return new LottoResult(statistics);
    }

    private Map<WinningStatistics, Integer> initMapWinningStatistics() {
        Map<WinningStatistics, Integer> statistics = new EnumMap<>(WinningStatistics.class);
        for (WinningStatistics value : WinningStatistics.values()) {
            statistics.put(value, 0);
        }
        return statistics;
    }

    private void validateDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        if (isDuplicateWinningLottoNumberAndBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 중복되었습니다.");
        }
    }

    private boolean isDuplicateWinningLottoNumberAndBonusNumber(BonusNumber bonusNumber) {
        return winningLotto.isContainsLottoNumber(bonusNumber.getBonusNumber());
    }
}

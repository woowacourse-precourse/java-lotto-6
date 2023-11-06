package lotto.domain;

import lotto.util.ExceptionMessage;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoAnalyzer {
    private final Map<LottoRank, Integer> winningStatistics = new EnumMap<>(LottoRank.class);
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoAnalyzer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = isValidBonus(bonusNumber);
    }

    private int isValidBonus(int bonusNumber) {
        if (this.winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_WINNING_NUMBER);
        }
        return bonusNumber;
    }

    public void analyzeLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int match = (int) winningNumbers.stream().filter(lottoNumbers::contains)
                    .distinct()
                    .count();
            boolean hasBonusNumber = lottoNumbers.contains(bonusNumber);
            LottoRank lottoRank = LottoRank.getRank(match, hasBonusNumber);
            winningStatistics.put(lottoRank, winningStatistics.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}

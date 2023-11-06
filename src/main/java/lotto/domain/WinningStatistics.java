package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private final Map<LottoRank, Integer> winningStatistics;

    private final LottoAnalyzer lottoAnalyzer;

    public WinningStatistics(LottoAnalyzer lottoAnalyzer) {
        this.winningStatistics = new EnumMap<>(LottoRank.class);
        this.lottoAnalyzer = lottoAnalyzer;
    }

    public void analyzeLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            int match = (int) lottoAnalyzer.getWinningNumbers().stream().filter(lottoNumbers::contains)
                    .distinct()
                    .count();
            boolean hasBonusNumber = lottoNumbers.contains(lottoAnalyzer.getBonusNumber());
            LottoRank lottoRank = LottoRank.getRank(match, hasBonusNumber);
            winningStatistics.put(lottoRank, winningStatistics.getOrDefault(lottoRank, 0) + 1);
        }
    }

    public Map<LottoRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}

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
            int match = getMatch(lottoNumbers);
            boolean hasBonusNumber = isContains(lottoNumbers);
            analyzeRank(match, hasBonusNumber);
        }
    }

    private void analyzeRank(int match, boolean hasBonusNumber) {
        LottoRank lottoRank = LottoRank.getRank(match, hasBonusNumber);
        winningStatistics.put(lottoRank, winningStatistics.getOrDefault(lottoRank, 0) + 1);
    }

    private boolean isContains(List<Integer> lottoNumbers) {
        int bonusNumber = lottoAnalyzer.getBonusNumber();
        return lottoNumbers.contains(bonusNumber);
    }

    private int getMatch(List<Integer> lottoNumbers) {
        List<Integer> winningNumbers = lottoAnalyzer.getWinningNumbers();
        return (int) winningNumbers.stream().filter(lottoNumbers::contains)
                .distinct()
                .count();
    }

    public Map<LottoRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }
}

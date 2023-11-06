package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTicket {
    private final List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<LottoGrade, Integer> getLottoStatistics(List<Integer> winningNumbers, int bonusNumber) {
        List<LottoMatchResult> matchResults = getMatchResults(winningNumbers, bonusNumber);
        return getStatistics(matchResults);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getLottoNumbers)
                .toList();
    }

    private List<LottoMatchResult> getMatchResults(List<Integer> winningNumbers, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.compare(winningNumbers, bonusNumber))
                .toList();
    }

    private Map<LottoGrade, Integer> getStatistics(List<LottoMatchResult> matchResults) {
        Map<LottoGrade, Integer> statistics = new EnumMap<>(LottoGrade.class);

        for (LottoMatchResult matchResult : matchResults) {
            LottoGrade lottoGrade = LottoGrade.of(matchResult.matchCount(), matchResult.matchBonus());
            statistics.put(lottoGrade, statistics.getOrDefault(lottoGrade, 0) + 1);
        }

        return statistics;
    }
}

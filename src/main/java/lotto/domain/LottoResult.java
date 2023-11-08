package lotto.domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import lotto.util.ResultGenerator;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto) {
        ResultGenerator resultGenerator = new ResultGenerator();
        this.result = resultGenerator.createLottoResult(lottos, winningLotto);
    }

    public List<String> getFormalizedResult() {
        List<String> formalizedResults = new ArrayList<>();
        result.keySet()
                .stream()
                .filter(rank -> rank.getPrize()>0) //!rank.equals(Rank.NOTHING)
                .sorted(Comparator.comparingLong(Rank::getPrize))
                .forEach(rank -> formalizedResults.add(rank.getFormalizedRank() + result.get(rank) + "개"));
        return formalizedResults;
    }

    public long getTotalReturn() {
        return Arrays.stream(Rank.values())
                .mapToLong(rank -> rank.getPrize() * result.getOrDefault(rank, 0))
                .sum();
    }
}

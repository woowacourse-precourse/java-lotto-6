package lotto.service;

import static lotto.constants.Constants.INITIAL_COUNT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.constants.Ranks;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.domain.WinningLotto;

public class ResultService {
    private final Ranks[] rankBenchmark = Ranks.values();

    public Result creatResult(Lottos Randomlottos, Bonus bonus, WinningLotto winningLotto) {
        List<Lotto> lottos = Randomlottos.getLottos();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        int bonusNumber = bonus.getNumber();
        List<Ranks> matches = lottos.stream().map(lotto -> detectRank(lotto, bonusNumber, winningNumbers))
                .collect(Collectors.toList());
        return mappingResult(matches);
    }

    private Result mappingResult(List<Ranks> ranks) {
        Map<Ranks, Integer> rankResult = new HashMap<>();
        initMatches(rankResult);
        setMatches(rankResult, ranks);
        return new Result(rankResult);
    }

    private void initMatches(Map<Ranks, Integer> rankResult) {
        Arrays.stream(rankBenchmark).forEach(rank -> rankResult.put(rank, INITIAL_COUNT));
    }


    private void setMatches(Map<Ranks, Integer> rankResult, List<Ranks> ranks) {
        ranks.forEach((rank) -> {
                    int rankCount = rankResult.get(rank);
                    rankResult.put(rank, rankCount + 1);
                }
        );
    }

    private Ranks detectRank(Lotto targetLotto, int bonusNumber, List<Integer> winningNumbers) {
        int matchCount = targetLotto.countMatchNumbers(winningNumbers);
        Ranks targetRank = rankBenchmark[matchCount];
        boolean isBonus = targetLotto.isContainNumber(bonusNumber);
        if (targetRank == Ranks.FIVE_MATCH && isBonus) {
            targetRank = Ranks.FIVE_MATCH_BONUS;
        }
        return targetRank;
    }
}

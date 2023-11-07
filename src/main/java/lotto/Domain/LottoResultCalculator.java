package lotto.Domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

public class LottoResultCalculator {

    private final List<Integer> matchNumbers;
    private final int bonusNumber;

    public LottoResultCalculator(List<Integer> matchNumbers, int bonusNumber) {
        this.matchNumbers = matchNumbers;
        this.bonusNumber = bonusNumber;
    }

    public EnumMap<LottoRank, Integer> computeLottoScore(List<Lotto> lottos) {
        EnumMap<LottoRank, Integer> lottoScore =
                new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values()).forEach(lottoRank -> {
            lottoScore.put(lottoRank, 0);
        });

        lottos.forEach(lotto -> {
            Optional<LottoRank> lottoRank = lotto.computeLottoRank(matchNumbers, bonusNumber);
            lottoRank.ifPresent(rank -> lottoScore.put(rank, lottoScore.get(rank) + 1));
        });

        return lottoScore;
    }
}

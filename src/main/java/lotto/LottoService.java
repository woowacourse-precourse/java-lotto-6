package lotto;

import java.util.EnumMap;
import java.util.List;

public class LottoService {

    private final WinningNumbers winningNumbers;
    private final LottoMachine lottoMachine;
    private final RankCounter rankCounter;
    private int input;

    public LottoService(WinningNumbers winningNumbers, LottoMachine lottoMachine, RankCounter rankCounter) {
        this.winningNumbers = winningNumbers;
        this.lottoMachine = lottoMachine;
        this.rankCounter = rankCounter;
    }

    public List<Lotto> getLottosWith(Money money) {
        input = money.amount();
        return lottoMachine.makeLottosWith(money);
    }

    public EnumMap<Rank, Integer> rank(List<Lotto> lottos) {
        lottos.stream()
                .map(winningNumbers::rank)
                .forEach(rankCounter::increaseCount);
        return rankCounter.getCountResult();
    }

    public double getRateOfReturn(EnumMap<Rank, Integer> countResult) {
        double output = getTotal(countResult);
        return output / input;
    }

    private double getTotal(EnumMap<Rank, Integer> countResult) {
        return countResult.keySet()
                .stream()
                .mapToDouble(rank -> rank.amountOf(countResult.get(rank)))
                .sum();
    }
}

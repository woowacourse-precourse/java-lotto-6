package lotto.service;

import java.util.List;
import lotto.Rank;
import lotto.domain.Lottos;

public class consoleOutDTO {
    private final int totalBought;
    private final List<List<Integer>> lottos;
    private final List<Rank> result;
    private final long profitRate;

    public consoleOutDTO(int totalBought, Lottos lottos, List<Rank> result, long profitRate) {
        this.totalBought = totalBought;
        this.lottos = lottos.getLottoBundle().stream()
                .map(x -> x.getNumbers().stream().toList())
                .toList();
        this.result = result;
        this.profitRate = profitRate;
    }

    public int getTotalBought() {
        return totalBought;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }

    public List<Rank> getResult() {
        return result;
    }

    public long getProfitRate() {
        return profitRate;
    }
}

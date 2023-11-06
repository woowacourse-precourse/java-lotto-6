package lotto.service;

import java.util.List;
import lotto.Rank;
import lotto.domain.Lottos;

public class ConsoleOutDTO {
    private final int totalBought;
    private final List<List<Integer>> lottos;
    private final List<Integer> result;
    private final double profitRate;

    public ConsoleOutDTO(int totalBought, Lottos lottos, List<Integer> result, double profitRate) {
        this.totalBought = totalBought;
        this.lottos = lottos.getLottoBundle().stream()
                .map(x -> x.getNumbers().stream().sorted().toList())
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

    public List<Integer> getResult() {
        return result;
    }

    public double getProfitRate() {
        return profitRate;
    }
}

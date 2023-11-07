package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseLotto {
    private final List<Lotto> lottos;

    public PurchaseLotto(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static PurchaseLotto purchaseAutoLotto(long lottoCount) {
        List<Lotto> autoLottos = LottoGenerator.autoGenerateBy(lottoCount);
        return new PurchaseLotto(autoLottos);
    }

    public int getAmount() {
        return this.lottos.size();
    }

    public long calculateTotalWinningPrice(WinningLotto winningLotto) {
        List<Rank> winningRanks = getWinningRanks(winningLotto);
        return winningRanks.stream()
                .mapToLong(Rank::getWinningPrice)
                .sum();
    }

    public Map<Rank, Long> calculateCountByWinningRank(WinningLotto winningLotto) {
        List<Rank> winningRanks = getWinningRanks(winningLotto);
        return winningRanks.stream()
                .collect(Collectors.groupingBy(r -> r, Collectors.counting()));
    }

    public List<List<Integer>> getAllLottoNumber() {
        return this.lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    private List<Rank> getWinningRanks(WinningLotto winningLotto) {
        return this.lottos.stream()
                .map(winningLotto::calcuateWinningRank)
                .collect(Collectors.toList());
    }

}

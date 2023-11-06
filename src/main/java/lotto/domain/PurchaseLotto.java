package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class PurchaseLotto {
    private final List<Lotto> lottos;

    public PurchaseLotto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static PurchaseLotto purchaseAutoLotto(long lottoCount) {
        List<Lotto> autoLottos = LongStream.rangeClosed(1, lottoCount)
                .mapToObj(c -> LottoGenerator.autoGenerate())
                .toList();

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

    public List<List<Integer>> getAllNumbers() {
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

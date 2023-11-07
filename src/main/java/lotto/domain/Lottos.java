package lotto.domain;


import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<String> getLottosAllSortedNumber() {
        return lottos.stream()
                .map(lotto -> lotto.getSortedNumbers())
                .toList();
    }

    public int getLottosAmount() {
        return lottos.size();
    }

    public List<LottoRank> calculateLottoResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        List<LottoRank> rank = lottos.stream()
                .map(lotto -> LottoRank.findLottoRank(
                        winningNumber.hitCount(lotto),
                        bonusNumber.isHitBonusNumber(lotto)
                ))
                .toList();

        return rank;
    }

}

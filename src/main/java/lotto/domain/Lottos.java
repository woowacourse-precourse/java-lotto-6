package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.Lotto;
public class Lottos {
    Purchase purchase;
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
    // 로또 List 갯수 validation
    public void validateLottoQuantity() {
        if (lottos.size() != purchase.getQuantity()) {
            throw new IllegalArgumentException("[ERROR] 구매한 로또의 개수가 일치하지 않습니다.");
        }
    }

    public  List<Rank> matchRanks(WinningLottoNumbers winningLottoNumbers) {
        return lottos.stream()
                .map(lotto -> mapToRank(lotto,winningLottoNumbers))
                .collect(Collectors.toList());
    }

    public Rank mapToRank(Lotto lotto, WinningLottoNumbers winningLottoNumbers) {
        int matchCount = lotto.matchCount(winningLottoNumbers.getWinningLotto());
        boolean isBonus = lotto.matchBonus(winningLottoNumbers);

        return Rank.isSecondMatch(matchCount, isBonus);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}

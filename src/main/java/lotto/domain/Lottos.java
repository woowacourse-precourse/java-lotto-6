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


    // 각 Lotto를 순회하며 Rank enum과 매칭
    public void matchRank(Lotto lotto) {
    }
    public List<Rank> getResults(WinningLottoNumbers winningLottoNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.matchNumber(winningLottoNumbers.getWinningLotto()))
                .map(Rank::valueOfMatchCount)
                .collect(Collectors.toList());
    }
    public List<Lotto> getLottos() {
        return lottos;
    }

}

package lotto.domain;

import java.util.List;
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
            throw new IllegalArgumentException("구매한 로또의 개수가 일치하지 않습니다.");
        }
    }

    public  void addLotto(List<Integer> lotto) {
        lottos.add((Lotto) lotto);
    }
}

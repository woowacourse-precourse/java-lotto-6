package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자가 발행한 모든 로또 번호 리스트 가지는 클래스
 */
public class UserLottos {
    private List<Lotto> lottos;

    public UserLottos() {
    }

    public UserLottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}

package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Long id;
    private List<Lotto> lottos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
}

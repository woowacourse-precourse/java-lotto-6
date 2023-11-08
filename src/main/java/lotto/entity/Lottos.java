package lotto.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void publishedLottoCount(Lotto lotto) {
        lottos.add(lotto);
    }

    /*public List<Lotto> getLottos() {
        return Collections.unmodifiableList(
                (List<Lotto>) FiledMapper.getFieldValue(this, MethodProperty.LOTTOS)
        );
    }*/

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}

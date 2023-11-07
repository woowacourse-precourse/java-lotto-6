package lotto.model;

import java.util.Collections;
import java.util.List;

public record Lottos(List<Lotto> lottoBundle) {

    @Override
    public List<Lotto> lottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }

    public int getSize() {
        return lottoBundle.size();
    }
}

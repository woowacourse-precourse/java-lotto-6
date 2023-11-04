package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBundle that = (LottoBundle) o;
        return Objects.equals(lottoBundle, that.lottoBundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBundle);
    }
}

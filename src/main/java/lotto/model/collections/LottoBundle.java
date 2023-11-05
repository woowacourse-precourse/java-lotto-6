package lotto.model.collections;

import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(List<Lotto> lottoBundle) {
        validateNull(lottoBundle);
        validateNotEmpty(lottoBundle);
        this.lottoBundle = lottoBundle;
    }

    private void validateNull(List<Lotto> lottoBundle) {
        if(lottoBundle==null){
            throw new IllegalArgumentException();
        }
    }

    private void validateNotEmpty(List<Lotto> lottoBundle) {
        if(lottoBundle.isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottoBundle() {
        return Collections.unmodifiableList(lottoBundle);
    }
}

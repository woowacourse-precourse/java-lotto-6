package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSet {
    private List<Lotto> lottoSet = new ArrayList<>();

    public LottoSet(Integer lottoQuantity){
        this.lottoSet = generateLottoSet(lottoQuantity);
    }

    public List<Lotto> getLottoSet() {
        return this.lottoSet;
    }

    private List<Lotto> generateLottoSet(int lottoQuantity){
        List<Lotto> lottoSet = new ArrayList<>();
        for(int i = 0; i < lottoQuantity; i++){
            lottoSet.add(new Lotto(Lotto.generateLotto()));
        }
        return lottoSet;
    }
}

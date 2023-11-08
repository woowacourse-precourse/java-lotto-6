package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private int lottoCount;
    private List<Lotto> lottoGroup;

    public LottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
        this.lottoGroup = lottoGroupGenerator();
    }

    public List<Lotto> lottoGroupGenerator() {
        List<Lotto> lottoGroup = new ArrayList<>();
        while (lottoGroup.size() < lottoCount) {
            lottoGroup.add(generateNum());
        }
        sortLottoGroup(lottoGroup);
        return lottoGroup;
    }

    public Lotto generateNum() {
        LottoNumberGenerator nums = new LottoNumberGenerator();
        return new Lotto(nums.generatorLottoNumbers());
    }

    public void sortLottoGroup(List<Lotto> lottoGroup) {
        lottoGroup.forEach(Lotto::sort);
    }

    public List<Lotto> getLottoGroup() {
        return lottoGroup;
    }
}

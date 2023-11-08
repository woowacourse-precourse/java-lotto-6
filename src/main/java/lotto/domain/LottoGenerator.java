package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private int lottoCount;
    public static List<Lotto> lottoGroup;

    public LottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
        lottoGroupGenerator();
    }

    public void lottoGroupGenerator() {
        lottoGroup = new ArrayList<>();
        while (lottoGroup.size() < this.lottoCount) {
            Lotto lotto = gerneratorNum();
            lottoGroup.add(lotto);
        }
        sortLottoGroup(lottoGroup);
    }
    public Lotto gerneratorNum() {
        LottoNumberGenerator numberGenerator = new LottoNumberGenerator();
        return new Lotto(numberGenerator.generatorLottoNumbers());
    }
    public void sortLottoGroup(List<Lotto> lottoGroup) {
        lottoGroup.forEach(Lotto->Lotto.sort());
    }


}

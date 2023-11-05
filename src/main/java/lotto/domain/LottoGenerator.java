package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private int lottoCount;
    private List<Lotto> lottoGroup;
    public LottoGenerator(int lottoCount) {
        this.lottoCount = lottoCount;
        lottoGroupGenerator();
    }

    public void lottoGroupGenerator(){
        lottoGroup = new ArrayList<>();
        while(lottoGroup.size()<lottoCount){
            lottoGroup.add(gerneratorNum());
        }
        sortLottoGroup();
    }
    public Lotto gerneratorNum(){
        LottoNumberGenerator nums = new LottoNumberGenerator();
        return new Lotto(nums.generatorLottoNumbers());
    }
    public void sortLottoGroup(){
        lottoGroup.forEach(lotto -> lotto.sort());
    }
}

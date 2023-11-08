package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> generateLottoList(int createLottoCounts){
        List<Lotto> lottos = new ArrayList<>();

        while(lottos.size() < createLottoCounts){
            lottos.add(generateLotto());
        }
        return lottos;
    }

    public Lotto generateLotto(){
        return new Lotto(generateLottoNumbers());
    }

    public List<Integer> generateLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1,45,6);
    }
}

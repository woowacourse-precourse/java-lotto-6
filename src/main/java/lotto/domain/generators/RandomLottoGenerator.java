package lotto.domain.generators;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomLottoGenerator {
    public Map<Integer, List<Integer>> generate(int boughtLottoSize){
        Map<Integer, List<Integer>> lottos = new HashMap<>();
        for(int i = 0 ; i < boughtLottoSize ; i++){
            lottos.put(i, Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }
        return lottos;
    }
}

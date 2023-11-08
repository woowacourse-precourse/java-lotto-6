package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    public static Map<Integer,List<Integer>> create(int count) {
        Map<Integer, List<Integer>> lottoNumbers = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            List<Integer> randomLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.put(i, randomLottoNumbers);
        }
        return lottoNumbers;
    }

}

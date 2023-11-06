package lotto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {

    public static Map<Integer,List<Integer>> create(int count) {
        Map<Integer, List<Integer>> lottoNumbers = new LinkedHashMap<>();
        for (int i = 0; i < count; i++) {
            lottoNumbers.put(i, AutomaticLottoNumbers.create());
        }
        return lottoNumbers;
    }

}

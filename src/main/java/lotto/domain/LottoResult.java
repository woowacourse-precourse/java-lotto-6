package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    Map<Integer, Integer> result;

    public LottoResult(){
    }

    private void generateResult(){
        result = new HashMap<>();
    }
}

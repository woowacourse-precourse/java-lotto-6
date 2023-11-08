package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LottoResult {
    private final Map<Integer, Integer> lottoresult;

    public LottoResult(Map<Integer, Integer> lottoresult){
        this.lottoresult = lottoresult;
    }

    public List<Integer> getValues(){
        return new ArrayList<>(lottoresult.values());
    }
}

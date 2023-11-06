package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class LottoResultCounter {
    private final Map<WinningInfo,Integer> resultCount;

    public LottoResultCounter(){
        this.resultCount = new HashMap<>();
    }

}

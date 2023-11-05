package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGenerator implements NumberGenerator{


    private static LottoGenerator instance;

    private LottoGenerator() {
    }


    public static LottoGenerator getInstance() {
        if(instance == null){
            return new LottoGenerator();
        }
        return instance;
    }

    @Override
    public List<Integer> generateNumberList() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}

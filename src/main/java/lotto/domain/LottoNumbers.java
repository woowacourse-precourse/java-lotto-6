package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class LottoNumbers {
    public LottoNumbers(){}
    private static List<Integer> lottoNumbers;

    public static List<Integer> setLottoNumbers(){
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
        return list;
    }
}

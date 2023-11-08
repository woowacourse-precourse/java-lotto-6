package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.constant.LottoConstant;
import lotto.constant.RottoResult;

import java.util.List;

public class Random {

    private static final int START = 1;
    private static final int END = 45;
    private static final int LENGTH = 6;

    public static List<Integer> generate(){
        return Randoms.pickUniqueNumbersInRange(LottoConstant.START.getNumber(),
                LottoConstant.END.getNumber(), LottoConstant.LENGTH.getNumber());
    }
}

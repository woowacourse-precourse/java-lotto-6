package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.LottoNumber;

public class RandomNumbers {

    public static List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_NUMBER.getNumber(),
                LottoNumber.MAX_NUMBER.getNumber(),
                LottoNumber.LIMIT_NUMBER.getNumber()
        );
        return lottoNumberList;
    }
}

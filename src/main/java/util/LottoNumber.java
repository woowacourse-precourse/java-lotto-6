package util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.List;
import lotto.LottoNumberBounds;

public class LottoNumber {

    public static List<Integer> makeLottoNumbers() {
        List<Integer> lottoNumberList = Randoms.pickUniqueNumbersInRange(
                LottoNumberBounds.MIN_NUMBER.getNumber(),
                LottoNumberBounds.MAX_NUMBER.getNumber(),
                LottoNumberBounds.LIMIT_NUMBER.getNumber()
        );
        sortedLottoNumbers(lottoNumberList);
        return lottoNumberList;
    }

    private static void sortedLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);
    }
}

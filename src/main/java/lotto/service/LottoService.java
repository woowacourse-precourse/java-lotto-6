package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constant.LottoNumber;

public class LottoService {
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoNumber.START_NUMBER.getNumber(),
                LottoNumber.END_NUMBER.getNumber(), LottoNumber.LOTTO_COUNT.getNumber());
    }
}

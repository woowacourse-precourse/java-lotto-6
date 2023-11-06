package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Constant.LottoNumber;

import java.util.List;

public class LottoRandomNumber {
    public List<Integer> createLottoRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(LottoNumber.FIRST_NUMBER.getLottoNumber(),LottoNumber.LAST_NUMBER.getLottoNumber(),LottoNumber.NUMBER_COUNT.getLottoNumber());
    }
}

package domain;

import static constants.GameConstant.DEFAULT_LOTTO_NUMBER_LENGTH;
import static constants.GameConstant.MAX_LOTTO_NUMBER;
import static constants.GameConstant.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGame {

    public List<Integer> createLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                DEFAULT_LOTTO_NUMBER_LENGTH);

    }

}

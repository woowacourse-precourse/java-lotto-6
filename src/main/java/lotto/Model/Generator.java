package lotto.Model;

import static lotto.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Generator {

    public List<Integer> generate6Nums(){
        return Randoms.pickUniqueNumbersInRange(START_INCLUSIVE.getNum(), END_INCLUSIVE.getNum(), LOTTO_NUMBER_COUNT.getNum());
    }
}

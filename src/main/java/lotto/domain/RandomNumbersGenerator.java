package lotto.domain;

import static lotto.domain.enums.Constant.LOTTO_MAX_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_MIN_NUMBER;
import static lotto.domain.enums.Constant.LOTTO_NUMBER_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {

    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER.getConstant(),
                LOTTO_MAX_NUMBER.getConstant(),
                LOTTO_NUMBER_LENGTH.getConstant()
        );
    }

}

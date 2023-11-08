package lotto.util;

import lotto.domain.EnumLotto;

import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public List<Integer> getRandomNumbers(){
        List<Integer> randomNumbers = createRandomNumbers();
        Collections.sort(randomNumbers);
        return randomNumbers;
    }

    private List<Integer> createRandomNumbers(){
        return Randoms.pickUniqueNumbersInRange(
                EnumLotto.START_NUMBER.getNumber(),
                EnumLotto.END_NUMBER.getNumber(),
                EnumLotto.LOTTO_LENGTH.getNumber());
    }
}

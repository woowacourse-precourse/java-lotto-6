package lotto.util;

import lotto.domain.EnumLotto;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public List<Integer> getRandomNumbers() {
        List<Integer> randomNumbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        EnumLotto.START_NUMBER.getNumber(),
                        EnumLotto.END_NUMBER.getNumber(),
                        EnumLotto.LOTTO_LENGTH.getNumber()
                )
        );
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}

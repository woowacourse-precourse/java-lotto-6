package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static lotto.domain.constants.DomainConstants.*;

public class RandomLottoNumberGenerator {

    public List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = new LinkedList<>(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_MIN_NUM,
                        LOTTO_MAX_NUM,
                        LOTTO_NUMBERS
                )
        );
        Collections.sort(randomNumbers);
        return randomNumbers;
    }
}

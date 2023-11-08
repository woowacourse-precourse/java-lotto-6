package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constant.LottoConstant.*;


public class RandomSixNumber {
    public List<Integer> generate() {
        List<Integer> randomNumber = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE);
        List<Integer> sortedRandomNumber = new ArrayList<>(randomNumber);
        Collections.sort(sortedRandomNumber);
        return sortedRandomNumber;
    }
}

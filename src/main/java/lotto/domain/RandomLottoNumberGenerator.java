package lotto.domain;

import static lotto.message.MessageConstants.LOTTO_MAX_NUMBER;
import static lotto.message.MessageConstants.LOTTO_MIN_NUMBER;
import static lotto.message.MessageConstants.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE));
        numbers.sort(Comparator.naturalOrder());
        return numbers;
    }
    
}

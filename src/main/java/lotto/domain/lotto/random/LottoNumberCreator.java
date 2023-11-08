package lotto.domain.lotto.random;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberCreator {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int MIN_LOTTO_NUMBER = 1;

    public Lotto createLotto() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (checkLottoSize(randomNumbers)) {
            int randomNumber = Randoms.pickNumberInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }

        return new Lotto(randomNumbers);
    }

    private boolean checkLottoSize(List<Integer> numbers) {
        return numbers.size() < LOTTO_NUMBER_SIZE;
    }
}

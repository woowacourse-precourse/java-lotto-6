package lotto.domain;

import static lotto.constant.GameRule.*;

import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validation.LottoValidator;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.lotto = numbers;
    }

    public static Lotto createLotto() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

    public List<Integer> getLotto() {
        return this.lotto;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.canBeLotto(numbers);
    }
}

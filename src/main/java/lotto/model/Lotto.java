package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.validate.LottoValidator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto generateRandomLotto() {
        List<Integer> immutableNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        List<Integer> numbers = new ArrayList<>(immutableNumbers);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

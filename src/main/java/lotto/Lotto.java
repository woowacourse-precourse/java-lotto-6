package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constants.LottoNumberConstants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Lotto> purchaseLottoEach(int numberOfLotto) {
        return IntStream.range(0, numberOfLotto)
                .mapToObj(i -> new Lotto(createLottoNumber()))
                .collect(Collectors.toList());
    }

    private List<Integer> createLottoNumber() {
        return pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_RANGE);
    }
}

package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoProperty.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != LOTTO_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().anyMatch(n -> n < MIN_LOTTO_NUMBER.getValue() || n > MAX_LOTTO_NUMBER.getValue())) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Lotto> generateLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE.getValue();
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private static Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

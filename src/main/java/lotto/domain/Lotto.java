package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import lotto.constants.Message;
import lotto.utils.NumberGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public static List<Lotto> createLottos(long count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers;
            numbers = NumberGenerator.generateSortedNumbers();
            lottos.add(new Lotto(numbers));
        }
        return Collections.unmodifiableList(lottos);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        checkNumberCount(numbers);
        checkDuplicated(numbers);
    }

    private static void checkDuplicated(List<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() < numbers.size()) {
            throw new IllegalArgumentException(Message.LOTTO_DUPLICATED_NUMBER_EXCEPTION);
        }
    }

    private static void checkNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.LOTTO_SIZE_EXCEPTION);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}

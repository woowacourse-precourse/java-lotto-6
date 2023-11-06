package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;
    private final int LOTTO_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            ErrorMessage.getDescription(ErrorMessage.SIZE);
            throw new IllegalArgumentException();
        }

        if (isDuplicate(numbers)) {
            ErrorMessage.getDescription(ErrorMessage.DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().collect(Collectors.toList()).size();
    }

    public static void createLotto(List<Integer> lottoNumber) {
        Lotto lotto = new Lotto(lottoNumber);
        LottoStore.getInstance().addLotto(lotto);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

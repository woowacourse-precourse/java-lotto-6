package lotto.lotto;

import java.util.List;
import lotto.config.LottoConfig;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_SLOT_NUMBER.getNum()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void printNumbers() {
        numbers.sort(Integer::compareTo);
        System.out.print("[");
        int size = numbers.size();
        for (int i = 0 ; i < size ; i++) {
            System.out.print(numbers.get(i));
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    // TODO: 추가 기능 구현
}

package lotto.domain;

import lotto.domain.validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        new LottoValidator(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public void showLottoNumber() {
        System.out.print("[");
        for (int i = 0; i < numbers.size(); i ++) {
            System.out.print(numbers.get(i));
            if (i != numbers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public boolean isContain(Integer number) {
        return numbers.contains(number);
    }
}

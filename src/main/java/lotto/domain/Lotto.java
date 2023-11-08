package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.util.Utils;
import lotto.validation.LottoValidation;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public int compareWithAnotherLotto(final Lotto another) {
        return another.compareWithNumberList(this.numbers);
    } // 당첨 갯수 Lotto 끼리 확인

    public void printLottoInfo() {
        OutputView.printLotto(numbers);
    }

    private int compareWithNumberList(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                .filter(number -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private void validate(List<Integer> numbers) {
        String Lotto = Utils.formatIntegerListToString(numbers);
        new LottoValidation().check(Lotto);
    }
}

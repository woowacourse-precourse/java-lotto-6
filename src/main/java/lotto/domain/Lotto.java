package lotto.domain;

import java.util.List;
import java.util.function.Predicate;
import lotto.system.Util;
import lotto.validator.LottoValidator;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        String checkParam = Util.makeIntegerListToStringFormat(numbers);
        new LottoValidator().check(checkParam);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int compareWithNumberList(List<Integer> anotherNumbers) {
        return (int) numbers.stream()
                .filter(number -> anotherNumbers.stream()
                        .anyMatch(Predicate.isEqual(number)))
                .count();
    }

    public int compareWithAnotherLotto(Lotto another) {
        return another.compareWithNumberList(this.numbers);
    }

    public void printLottoInfo() {
        OutputView.printLotto(numbers);
    }
}

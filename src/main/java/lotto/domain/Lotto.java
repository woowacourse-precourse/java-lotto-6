package lotto.domain;

import lotto.view.OutputView;
import lotto.util.Util;
import lotto.verifier.LottoVerifier;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        String forCheck = Util.makeIntegerListToStringFormat(numbers);
        new LottoVerifier().check(forCheck);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public void printLottoInfo() {
        OutputView.printLotto(numbers);
    }

    public int compareWithAnotherLotto(Lotto another) {
        return (int) numbers.stream()
                .filter(another::contains)
                .count();
    }

}

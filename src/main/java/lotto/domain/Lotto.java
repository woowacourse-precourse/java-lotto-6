package lotto.domain;

import static lotto.config.LottoConfig.NUMBER_OF_NUMBERS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isDefaultSize(numbers);
        hasDuplicatedNumber(numbers);
    }

    private void isDefaultSize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_NUMBERS.getNumber()) {
            throw new IllegalArgumentException("로또 번호의 개수가 6개가 아닙니다.");
        }
    }

    private void hasDuplicatedNumber(List<Integer> numbers) {
        Set<Integer> numbersSet = new HashSet<>(numbers);
        if (numbersSet.size() != NUMBER_OF_NUMBERS.getNumber()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public void printNaturalOrder() {
        List<Integer> naturalOrderNumbers = new ArrayList<>(numbers);
        naturalOrderNumbers.sort(Comparator.naturalOrder());
        OutputView.printMessage(naturalOrderNumbers.toString());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}

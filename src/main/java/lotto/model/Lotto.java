package lotto.model;

import java.util.List;
import lotto.validation.LottoNumberValidator;
import lotto.view.OutputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = List.copyOf(numberSortWithAscendingOrder(numbers));
    }

    public void displayLottoNumbers() {
        OutputView.printLottoNumbers(numbers);
    }

    private List<Integer> numberSortWithAscendingOrder(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        LottoNumberValidator.validateLottoNumber(numbers);
    }
}

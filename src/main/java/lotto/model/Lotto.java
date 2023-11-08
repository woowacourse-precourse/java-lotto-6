package lotto.model;

import java.util.List;
import java.util.Optional;
import lotto.utils.LottoNumberValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoNumberValidator.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getSortedNumbers() {
        return sortNumbers(this.numbers);
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        return numbers
                .stream()
                .sorted()
                .toList();
    }

    public Optional<LottoPlace> calculateLottoPlace(WinningLotto winningLotto) {
        LottoStatus judgeStatus = LottoStatus.createEmptyStatus();

        for (Integer number : numbers) {
            NumberStatus numberStatus = winningLotto.judgeNumber(number);
            judgeStatus.update(numberStatus);
        }
        return LottoPlace.judgeLottoPlace(judgeStatus);
    }
}

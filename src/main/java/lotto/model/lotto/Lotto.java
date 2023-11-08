package lotto.model.lotto;

import java.util.List;
import java.util.Optional;
import lotto.model.calculate.LottoStatus;
import lotto.model.enums.LottoPlace;
import lotto.model.enums.NumberStatus;
import lotto.model.lottoPick.PickedLotto;
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

    public Optional<LottoPlace> calculateLottoPlace(PickedLotto pickedLotto) {
        LottoStatus judgeStatus = LottoStatus.createEmptyStatus();

        for (Integer number : numbers) {
            NumberStatus numberStatus = pickedLotto.judgeNumber(number);
            judgeStatus.update(numberStatus);
        }
        return LottoPlace.judgeLottoPlace(judgeStatus);
    }
}

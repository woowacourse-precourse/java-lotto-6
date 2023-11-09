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

    public LottoRank calculateLottoRank(WinningLotto winningLotto) {
        int matchCount = calculateMatchCount(winningLotto.getWinningNumber());
        boolean matchBonus = isMatchBonus(winningLotto.getBonusNumber());

        return LottoRank.calculateRank(matchCount, matchBonus);
    }

    private boolean isMatchBonus(BonusNumber bonusNumber) {
        return numbers.contains(bonusNumber.getBonusNumber());
    }

    private int calculateMatchCount(WinningNumber winningNumber) {
        List<Integer> winningNumbers = winningNumber.getWinningNumbers();

        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
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

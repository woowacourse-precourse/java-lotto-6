package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<Lotto> winningLottoNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningLottoNumbers = generate(numbers);
        this.bonusNumber = bonusNumber;
    }

    private List<Lotto> generate(List<Integer> numbers) {
        return List.of(new Lotto(numbers));
    }

    public int compareWith(Lotto lotto) {
        int userMatchedCount = 0;
        for (Lotto winningNumbers : winningLottoNumbers) {
            for (Integer userNumber : lotto.getNumbers()) {
                if (winningNumbers.getNumbers().contains(userNumber)) {
                    userMatchedCount++;
                }
            }
        }
        return userMatchedCount;
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}

package lotto;

import java.util.List;

public class WinningNumbers {
    private final List<Lotto> winningLottoNumbers;

    public WinningNumbers(List<Integer> numbers) {
        this.winningLottoNumbers = generate(numbers);
    }

    private List<Lotto> generate(List<Integer> numbers) {
        return List.of(new Lotto(numbers));
    }

    public int compareWith(Lotto lotto) {
        int userMatchedCount = 0;
        for (Lotto winningLotto : winningLottoNumbers) {
            for (Integer userNumber : lotto.getNumbers()) {
                if (winningLotto.getNumbers().contains(userNumber)) {
                    userMatchedCount++;
                }
            }
        }
        return userMatchedCount;
    }
}

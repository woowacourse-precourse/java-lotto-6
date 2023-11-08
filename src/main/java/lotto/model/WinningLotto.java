package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private final Lotto winningNumbers;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public static Result of(int matchCount, boolean hasBonus) {
        return new Result(matchCount, hasBonus);
    }
    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

    public List<Result> calculateWinningResults(List<Lotto> lottos, WinningLotto winningLotto) {
        List<Result> winningResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            Result winningResult = calculateWinningResult(lotto, winningLotto);
            winningResults.add(winningResult);
        }
        return winningResults;
    }

    private Result calculateWinningResult(Lotto userLotto, WinningLotto winningLotto) {
        int matchCount = countMatchNumbers(userLotto, winningLotto);
        boolean hasBonus = userLotto.contains(winningLotto.getBonusNumber());

        if (hasBonus) {
            matchCount++;
        }

        return Result.of(matchCount, hasBonus);
    }

    private int countMatchNumbers(Lotto userLotto, WinningLotto winningLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto::contains)
                .count();
    }
}

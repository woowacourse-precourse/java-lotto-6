package lotto.model;

import static lotto.ErrorMessage.DUPLICATE_WIN_BONUS;

import java.util.List;
import lotto.validator.LottoValidator;
import lotto.view.OutPutView;

public class WinLotto {
    private final WinNumbers winNumbers;
    private final BonusNumber bonusNumber;

    private WinLotto(WinNumbers winNumbers, BonusNumber bonusNumber) {
        this.winNumbers = winNumbers;
        this.bonusNumber = bonusNumber;
    }


    public static WinLotto issueWinLotto(WinNumbers winNumbers, BonusNumber bonusNumber) {
        if (isValid(winNumbers.getNumbers(), bonusNumber.getNumber())) {
            return new WinLotto(winNumbers, bonusNumber);
        }
        return null;
    }

    private static boolean isValid(List<Integer> numbers, int bonusNumber) {
        return LottoValidator.isDuplicateBonusNumber(numbers, bonusNumber);
    }

    public Ranking findOutLottoRanking(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = calculateMatchCount(numbers);
        boolean isMatchBonus = numbers.contains(bonusNumber.getNumber());
        return Ranking.of(matchCount, isMatchBonus);
    }

    private int calculateMatchCount(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winNumbers.getNumbers()::contains)
                .count();
    }
}

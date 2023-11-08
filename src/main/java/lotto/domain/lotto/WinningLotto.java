package lotto.domain.lotto;

import java.util.List;
import java.util.Optional;
import lotto.domain.Rank;
import lotto.global.constant.message.ErrorMessage;
import lotto.global.exception.LottoIllegalArgumentException;

public class WinningLotto extends Lotto {

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
    }


    public void checkDuplicationWithBonusNumber(BonusNumber bonusNumber) {
        if (containsNumber(bonusNumber)) {
            throw new LottoIllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATION_ERROR);
        }
    }

    public Optional<Rank> compareNumbers(Lotto lotto, BonusNumber bonusNumber) {
        int matchCount = checkMatchCount(lotto, this.getNumbers());
        boolean isBonusNumberMatched = lotto.containsNumber(bonusNumber);

        if (matchCount < Rank.FIFTH.getMatchCount()) {
            return Optional.empty();
        }
        return Optional.of(Rank.judgeBy(matchCount, isBonusNumberMatched));
    }


    private int checkMatchCount(Lotto lotto, List<LottoNumber> winningNumbers) {
        int matchCount = 0;
        for (LottoNumber winningNumber : winningNumbers) {
            if (lotto.containsNumber(winningNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}

package lotto.model;

import static lotto.util.Constants.ERROR;
import static lotto.util.enums.LottoResult.*;

import java.util.Optional;


public class ResultComparator {
    private static final int MATCH_5 = 5;

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    private ResultComparator(){
        throw new AssertionError(ERROR + "기본 생성자로 생성할 수 없습니다.");
    }

    public ResultComparator(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Optional<String> result(Lotto lotto) {
        Integer match = resultCompare(lotto);
        if (hasMatchedBonus(lotto, match)) {
            return Optional.ofNullable(MATCH_5_BONUS.getDescription());
        }
        return fromMatchCount(match);
    }

    private Integer resultCompare(Lotto lotto) {
        return lotto.countMatchingNumbers(winningNumbers);
    }

    private boolean hasMatchedBonus(Lotto lotto, Integer matchCount) {
        return lotto.hasMatchedBonus(bonusNumber) && matchCount == MATCH_5;
    }
}

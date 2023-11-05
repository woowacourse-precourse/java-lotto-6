package lotto;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.MatchingCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MatchingCountTest {

    @DisplayName("당첨번호와 일치하는 개수에 따라 matchingCounts 업데이트되어야 한다. ")
    @Test
    void confirmLottoMatchingWinningNumbers() {

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto sixMatchingLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber("7",winningNumbers);
        MatchingCount matchingCount = new MatchingCount();

        matchingCount.updateMatchingCounts(sixMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(0,0,0,0,1));

        Lotto bonusMatchingLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        matchingCount.updateMatchingCounts(bonusMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(0,0,0,1,1));

        Lotto threeMatchingLotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        matchingCount.updateMatchingCounts(threeMatchingLotto, winningNumbers, bonusNumber);
        Assertions.assertEquals(matchingCount.getMatchingCounts(), List.of(1,0,0,1,1));
    }

}

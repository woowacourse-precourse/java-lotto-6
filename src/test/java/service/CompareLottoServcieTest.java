package service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static service.CompareLottoServcie.calculateRank;

import View.OutputView;
import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CompareLottoServcieTest {

    @DisplayName("등수가 잘 계산 되었는지 확인")
    @Test
    void checkRankCalculate() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    Amount amount = new Amount(8000);
                    Lottos lottos = new Lottos(amount);
                    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
                    BonusNumber bonusNumber = new BonusNumber(7, lotto);
                    WinningNumbers winningNumbers = new WinningNumbers(lotto,bonusNumber);

                    Rank rank = calculateRank(amount, lottos, winningNumbers);
                    assertEquals("[1, 2, 3, 4, 5, 6, 6, 6]", rank.toString());
                },
                List.of(1,2,3,4,5,6),
                List.of(1,2,3,4,5,7),
                List.of(1,2,3,4,5,10),
                List.of(1,2,3,4,10,11),
                List.of(1,2,3,10,11,12),
                List.of(1,2,10,11,12,13),
                List.of(1,10,11,12,13,14),
                List.of(10,11,12,13,14,15)
        );
    }
}
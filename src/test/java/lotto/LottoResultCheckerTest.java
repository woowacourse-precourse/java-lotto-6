package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoResultCheckerTest {
    Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto[] userLotto = {new Lotto(List.of(1, 2, 7, 8, 9, 10)), new Lotto(List.of(1, 2, 3, 4, 5, 7)), new Lotto(List.of(7, 8, 9, 10, 11, 12))};
    int bonusNumber = 7;
    LottoResultChecker lottoResultChecker = new LottoResultChecker(winningLotto, userLotto, bonusNumber);

    @Test
    @DisplayName("당첨번호와 일치하는 로또의 개수가 정상적으로 계산된다.")
    void countMatchNumbers() {
        // 1. 당첨 번호가 없는 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        Lotto myLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(0, lottoResultChecker.countMatchNumbers(myLotto));

        // 2. 당첨 번호가 1개인 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(1, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 2, 3, 4, 5, 6))));

        // 3. 당첨 번호가 2개인 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(2, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 3, 4, 5, 6))));

        // 4. 당첨 번호가 3개인 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(3, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 23, 4, 5, 6))));

        // 5. 당첨 번호가 4개인 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(4, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 23, 24, 5, 6))));

        // 6. 당첨 번호가 5개인 경우
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(5, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 23, 24, 25, 6))));

        // 7. 당첨 번호가 6개인 경우 -2등 당첨(일치하는 6개 중 1개는 보너스 번호인 경우)
        lottoResultChecker.bonusNumber = 27;
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(5.5, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 23, 24, 25, 27))));

        // 8. 당첨 번호가 6개인 경우 - 1등 당첨
        lottoResultChecker.winningNumbers = (List.of(21, 22, 23, 24, 25, 26));
        assertEquals(6, lottoResultChecker.countMatchNumbers(new Lotto(List.of(21, 22, 23, 24, 25, 26))));


    }

    @Test
    @DisplayName("보너스 번호가 이미 당첨번호에 포함되어 있는지 정상적으로 확인한다.")
    void hasBonusNumber() {
        // 1. 당첨 번호에 포함된 경우(중복)
        lottoResultChecker.bonusNumber = 1;
        assertTrue(lottoResultChecker.hasBonusNumber(List.of(1, 2, 3, 4, 5, 6)));

        // 2. 당첨번호에 포함되지 않은 경우
        lottoResultChecker.bonusNumber = 8;
        assertFalse(lottoResultChecker.hasBonusNumber(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("당첨 금액이 정상적으로 계산된다.")
    void calculateReward() {
        // 1. 1등 당첨 - 6개가 일치하는 경우
        assertEquals(Rank.FIRST_PLACE.getReward(), lottoResultChecker.calculateReward(6));

        // 2. 2등 당첨 - 5.5개가 일치하는 경우(보너스 번호와 일치하면 0.5라고 취급)
        assertEquals(Rank.SECOND_PLACE.getReward(), lottoResultChecker.calculateReward(5.5));

        // 3. 3등 당첨 - 5개가 일치하는 경우
        assertEquals(Rank.THIRD_PLACE.getReward(), lottoResultChecker.calculateReward(5));

        // 4. 4등 당첨 - 4개가 일치하는 경우
        assertEquals(Rank.FOURTH_PLACE.getReward(), lottoResultChecker.calculateReward(4));

        // 5. 5등 당첨 - 3개가 일치하는 경우
        assertEquals(Rank.FIFTH_PLACE.getReward(), lottoResultChecker.calculateReward(3));

        // 6. 당첨X - 2개가 일치하는 경우
        assertEquals(Rank.NONE.getReward(), lottoResultChecker.calculateReward(2));

        // 7. 당첨X - 1개가 일치하는 경우
        assertEquals(Rank.NONE.getReward(), lottoResultChecker.calculateReward(1));

        // 8. 당첨X - 0개가 일치하는 경우
        assertEquals(Rank.NONE.getReward(), lottoResultChecker.calculateReward(0));
    }

    @Test
    @DisplayName("수익률이 정상적으로 계산된다.")
    void calculateReturnRation() {
        assertEquals(Math.round((lottoResultChecker.reward / (Application.ONE_LOTTO_PRICE * lottoResultChecker.userLottoNumbers.length)) * 100.0) / 100.0, lottoResultChecker.calculateReturnRatio());
    }
}
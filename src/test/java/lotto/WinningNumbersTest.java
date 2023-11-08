package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Prize;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    @Test
    void 당첨과_로또를_비교하여_정확한_결과를_반환해야_한다() {
        // given: 당첨 번호와 구매한 로또 번호가 주어집니다.
        WinningNumbers winningNumbers = getWinningNumbers();

        List<Lotto> purchasedLottos = getPurchasedLottos();

        // when: 당첨 결과를 계산합니다.
        Map<Prize, Integer> prizeResults = winningNumbers.calculatePrizes(purchasedLottos);

        // then: 각 등수별 당첨 티켓 수를 검증합니다.
        Assertions.assertAll(
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.FIRST).intValue()),
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.SECOND).intValue()),
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.THIRD).intValue()),
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.FOURTH).intValue()),
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.FIFTH).intValue()),
            () -> Assertions.assertEquals(1, prizeResults.get(Prize.NONE).intValue())
        );
    }

    @Test
    void 보너스_번호_불일치시_3등() {
        // given
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        Lotto secondPrizeWithoutBonusLotto = new Lotto(
            Arrays.asList(1, 2, 3, 4, 5, 8)); // 보너스 번호 없이 5개 일치

        List<Lotto> purchasedLottos = Arrays.asList(secondPrizeWithoutBonusLotto);

        // when
        Map<Prize, Integer> prizeResults = winningNumbers.calculatePrizes(purchasedLottos);

        // then
        Assertions.assertEquals(0, prizeResults.get(Prize.SECOND).intValue());
        Assertions.assertEquals(1, prizeResults.get(Prize.THIRD).intValue());
    }

    @Test
    void none처리() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningNumbers winningNumbers = new WinningNumbers(winningLotto, bonusNumber);

        Lotto noMatchLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)); // 아무것도 매치되지 않음

        List<Lotto> purchasedLottos = Arrays.asList(noMatchLotto);

        Map<Prize, Integer> prizeResults = winningNumbers.calculatePrizes(purchasedLottos);

        Assertions.assertEquals(1, prizeResults.get(Prize.NONE).intValue());
        Assertions.assertEquals(0, prizeResults.get(Prize.FIRST).intValue());
        Assertions.assertEquals(0, prizeResults.get(Prize.SECOND).intValue());
        Assertions.assertEquals(0, prizeResults.get(Prize.THIRD).intValue());
        Assertions.assertEquals(0, prizeResults.get(Prize.FOURTH).intValue());
        Assertions.assertEquals(0, prizeResults.get(Prize.FIFTH).intValue());
    }

    private WinningNumbers getWinningNumbers() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        return new WinningNumbers(winningLotto, bonusNumber);
    }

    private List<Lotto> getPurchasedLottos() {
        Lotto firstPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)); // 1등
        Lotto secondPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)); // 2등 (보너스 번호 일치)
        Lotto thirdPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)); // 3등
        Lotto fourthPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 45, 44)); // 4등
        Lotto fifthPrizeLotto = new Lotto(Arrays.asList(1, 2, 3, 42, 41, 40)); // 5등
        Lotto noPrizeLotto = new Lotto(Arrays.asList(10, 11, 12, 13, 14, 15)); // 당첨 안됨

        return Arrays.asList(
            firstPrizeLotto,
            secondPrizeLotto,
            thirdPrizeLotto,
            fourthPrizeLotto,
            fifthPrizeLotto,
            noPrizeLotto
        );
    }
}

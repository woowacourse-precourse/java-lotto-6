package lotto;

import static lotto.DrawResult.FIFTH_PRIZE;
import static lotto.DrawResult.FIRST_PRIZE;
import static lotto.DrawResult.FOURTH_PRIZE;
import static lotto.DrawResult.SECOND_PRIZE;
import static lotto.DrawResult.THIRD_PRIZE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {

    @DisplayName("당첨금 계산 (보너스 숫자 안 맞은 경우)")
    @Test
    void calculateWinningAmountWithoutBonusNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 32, 43, 29, 45);
        int bonusNumber = 25;
        LottoService service = new LottoService(winningNumbers, bonusNumber);
        Lotto lotto1stPlace = new Lotto(winningNumbers);
        Lotto lotto3rdPlace = new Lotto(List.of(45, 2, 43, 32, 1, 30));
        Lotto lotto4thPlace = new Lotto(List.of(45, 29, 43, 32, 3, 30));
        Lotto lotto5thPlace = new Lotto(List.of(1, 29, 43, 31, 3, 30));
        // when
        DrawResult actualResultOf1stPlaceLotto = service.checkResult(lotto1stPlace);
        DrawResult actualResultOf3rdPlaceLotto = service.checkResult(lotto3rdPlace);
        DrawResult actualResultOf4thPlaceLotto = service.checkResult(lotto4thPlace);
        DrawResult actualResultOf5thPlaceLotto = service.checkResult(lotto5thPlace);
        // then
        assertThat(actualResultOf1stPlaceLotto).isEqualTo(FIRST_PRIZE);
        assertThat(actualResultOf3rdPlaceLotto).isEqualTo(THIRD_PRIZE);
        assertThat(actualResultOf4thPlaceLotto).isEqualTo(FOURTH_PRIZE);
        assertThat(actualResultOf5thPlaceLotto).isEqualTo(FIFTH_PRIZE);
    }


    @DisplayName("당첨금 계산 (보너스 숫자가 맞은 경우)")
    @Test
    void calculateWinningAmountWithBonusNumber() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 32, 43, 29, 45);
        int bonusNumber = 25;
        LottoService service = new LottoService(winningNumbers, bonusNumber);
        Lotto lotto2ndPlace = new Lotto(List.of(45, 2, 43, 32, 1, 25));
        Lotto lotto4thPlaceWithBonus = new Lotto(List.of(45, 29, 43, 32, 3, 25));
        Lotto lotto5thPlaceWithBonus = new Lotto(List.of(1, 29, 43, 31, 3, 25));
        // when
        DrawResult actualResultOf2ndPlaceLotto = service.checkResult(lotto2ndPlace);
        DrawResult actualResultOf4thPlaceWithBonusLotto = service.checkResult(lotto4thPlaceWithBonus);
        DrawResult actualResultOf5thPlaceWithBonusLotto = service.checkResult(lotto5thPlaceWithBonus);
        // then
        assertThat(actualResultOf2ndPlaceLotto).isEqualTo(SECOND_PRIZE);
        assertThat(actualResultOf4thPlaceWithBonusLotto).isEqualTo(FOURTH_PRIZE);
        assertThat(actualResultOf5thPlaceWithBonusLotto).isEqualTo(FIFTH_PRIZE);
    }
}

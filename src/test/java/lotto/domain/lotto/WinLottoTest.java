package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.lottoresult.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
    private final WinLotto winLotto = new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(7));

    @DisplayName("WinLotto 와 Lotto 를 비교해 같은 숫자 개수를 반환한다.")
    @Test
    void winLottoTest_1() {
        Lotto threeSameWinLotto = new Lotto(List.of(1, 2, 3, 7, 8, 9));
        Lotto sixSameWinLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        int numberOfSame_1 = winLotto.compareWithLottoNumber(threeSameWinLotto);
        int numberOfSame_2 = winLotto.compareWithLottoNumber(sixSameWinLotto);
        assertThat(numberOfSame_1).isEqualTo(3);
        assertThat(numberOfSame_2).isEqualTo(6);
    }

    @DisplayName("WinLotto 와 Lotto 를 비교해 보너스 숫자의 일치 여부를 반환한다.")
    @Test
    void winLottoTest_2() {
        Lotto bonusSameWinLotto = new Lotto(List.of(7, 2, 3, 1, 8, 9));
        Lotto bonusNotSameWinLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        boolean isContainBonusNumber_1 = winLotto.compareWithBonusNumber(bonusSameWinLotto);
        boolean isContainBonusNumber_2 = winLotto.compareWithBonusNumber(bonusNotSameWinLotto);
        assertThat(isContainBonusNumber_1).isTrue();
        assertThat(isContainBonusNumber_2).isFalse();
    }

    @DisplayName("당첨 로또와 특정 등수에 맞는 로또를 비교했을 때 알맞은 LottoResult 를 반환한다.")
    @Test
    void getLottoResultTest() {
        Lotto secondPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        Lotto thirdPrizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        Lotto nonePrizeLotto = new Lotto(List.of(1, 2, 7, 8, 9, 10));

        assertThat(winLotto.getLottoResult(secondPrizeLotto)).isEqualTo(LottoResult.SECOND);
        assertThat(winLotto.getLottoResult(thirdPrizeLotto)).isEqualTo(LottoResult.THIRD);
        assertThat(winLotto.getLottoResult(nonePrizeLotto)).isEqualTo(LottoResult.NONE);
    }
}

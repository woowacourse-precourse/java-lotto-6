package lotto.model;

import static lotto.model.WinningLotto.BONUS;
import static lotto.model.WinningLotto.SIX;
import static lotto.model.WinningLotto.ZERO;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {

    @Test
    @DisplayName("매치 개수로 조회는 성공한다.")
    public void 매치_개수로_조회는_성공한다() {
        //given
        List<Integer> matchCounts = Arrays.stream(WinningLotto.values())
                .map(WinningLotto::getMatchCount)
                .toList();

        //when
        List<WinningLotto> fromWinningLottos = matchCounts.stream()
                .map(WinningLotto::from)
                .toList();

        //then
        List<WinningLotto> winningLottos = Arrays.stream(WinningLotto.values())
                .toList();
        assertThat(winningLottos).containsAll(fromWinningLottos);
    }

    @Test
    @DisplayName("찾을 수 없는 매치 개수로 조회할 경우 ZERO를 반환한다.")
    public void 찾을_수_없는_매치_개수로_조회할_경우_ZERO를_반환한다() {
        //given
        int invalidMatchCount = 7;

        //when
        WinningLotto winningLotto = WinningLotto.from(invalidMatchCount);

        //then
        assertThat(winningLotto).isEqualTo(ZERO);
    }

    @Test
    @DisplayName("보너스 당첨 로또인지 판별한다.")
    public void 보너스_당첨_로또인지_판별한다() {
        //when
        boolean bonusResult = BONUS.isBonus();
        boolean noBonusResult = SIX.isBonus();

        //then
        assertThat(bonusResult).isTrue();
        assertThat(noBonusResult).isFalse();
    }
}

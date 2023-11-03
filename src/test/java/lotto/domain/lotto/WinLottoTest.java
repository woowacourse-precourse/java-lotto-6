package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinLottoTest {
    private final Lotto lottoContainOneToSix = new Lotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("WinLotto 와 Lotto 를 비교해 같은 숫자 개수를 반환한다.")
    @Test
    void winLottoTest_1() {
        WinLotto threeSameWinLotto = new WinLotto(List.of(1, 2, 3, 7, 8, 9), 10);
        WinLotto sixSameWinLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        int numberOfSame_1 = threeSameWinLotto.compareWithLottoNumber(lottoContainOneToSix);
        int numberOfSame_2 = sixSameWinLotto.compareWithLottoNumber(lottoContainOneToSix);
        assertThat(numberOfSame_1).isEqualTo(3);
        assertThat(numberOfSame_2).isEqualTo(6);
    }

    @DisplayName("WinLotto 와 Lotto 를 비교해 보너스 숫자의 일치 여부를 반환한다.")
    @Test
    void winLottoTest_2() {
        WinLotto bonusSameWinLotto = new WinLotto(List.of(1, 2, 3, 7, 8, 9), 6);
        WinLotto bonusNotSameWinLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);

        boolean isContainBonusNumber_1 = bonusSameWinLotto.compareWithBonusNumber(lottoContainOneToSix);
        boolean isContainBonusNumber_2 = bonusNotSameWinLotto.compareWithBonusNumber(lottoContainOneToSix);
        assertThat(isContainBonusNumber_1).isTrue();
        assertThat(isContainBonusNumber_2).isFalse();
    }
}

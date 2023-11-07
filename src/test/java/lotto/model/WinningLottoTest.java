package lotto.model;

import static lotto.exception.LottoException.DUPLICATED_BONUS_NUMBER;
import static lotto.exception.LottoException.LESS_THAN_MINIMUM_LOTTO_NUMBER;
import static lotto.exception.LottoException.MORE_THAN_MAXIMUM_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.model.lotto.Lotto;
import lotto.model.rank.LottoRank;
import lotto.model.rank.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    Lotto lotto;
    int bonusNumber;
    WinningLotto winningLotto;

    @BeforeEach
    void setTest() {
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        winningLotto = new WinningLotto(lotto, bonusNumber);
    }

    @DisplayName("보너스 번호가 1보다 작은 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByLessMinimum() {
        //given
        int bonusNumber = 0;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LESS_THAN_MINIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 45보다 큰 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByOverMaximum() {
        //given
        int bonusNumber = 46;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MORE_THAN_MAXIMUM_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("보너스 번호가 로또 번호와 중복된 숫자라면 예외가 발생한다.")
    @Test
    void createWinningLottoByDuplicatedBonusNumber() {
        //given
        int bonusNumber = 1;

        //when ,then
        assertThatThrownBy(() -> new WinningLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_BONUS_NUMBER.getMessage());
    }

    @DisplayName("당첨된 번호가 2개 이하이면 가장 낮은 순위를 반환한다.")
    @Test
    void testCalculateLottoRankNone() {
        //given
        Lotto target = new Lotto(List.of(1, 2, 10, 11, 12, 13));

        //when
        LottoRank rank = winningLotto.calculateLottoRank(target);

        //then
        assertThat(rank).isEqualTo(LottoRank.NONE);
    }

    @DisplayName("당첨된 번호가 5개이고 보너스 번호가 없다면 3등을 반환한다.")
    @Test
    void testCalculateLottoRankThird() {
        //given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 8));

        //when
        LottoRank rank = winningLotto.calculateLottoRank(target);

        //then
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("당첨된 번호가 5개이고 보너스 번호가 있다면 2등을 반환한다.")
    @Test
    void testCalculateLottoRankSecond() {
        //given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        //when
        LottoRank rank = winningLotto.calculateLottoRank(target);

        //then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("당첨된 번호가 6개이면 1등을 반환한다.")
    @Test
    void testCalculateLottoRankFirst() {
        //given
        Lotto target = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        //when
        LottoRank rank = winningLotto.calculateLottoRank(target);

        //then
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }
}

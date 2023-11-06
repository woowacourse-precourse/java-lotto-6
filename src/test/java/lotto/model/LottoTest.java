package lotto.model;

import static lotto.exception.InvalidLottoException.InvalidLottoError.DUPLICATE_LOTTO;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_COUNT;
import static lotto.exception.InvalidLottoException.InvalidLottoError.INVALID_LOTTO_RANGE;
import static lotto.model.Lotto.LOTTO_MAX_NUMBER;
import static lotto.model.Lotto.LOTTO_MIN_NUMBER;
import static lotto.model.WinningLotto.BONUS;
import static lotto.model.WinningLotto.SIX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @Test
    @DisplayName("로또 번호의 개수가 6개 미만이면 예외가 발생한다.")
    public void 로또_번호의_개수가_6개_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATE_LOTTO.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 최대값을 초과하면 예외가 발생한다.")
    public void 로또_번호가_최대값을_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, LOTTO_MAX_NUMBER + 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_RANGE.getMessage());
    }

    @Test
    @DisplayName("로또 번호가 최소값 미만이면 예외가 발생한다.")
    public void 로또_번호가_최소값_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, LOTTO_MIN_NUMBER - 1)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LOTTO_RANGE.getMessage());
    }

    @Nested
    @DisplayName("당첨 로또 조회 테스트")
    class GetWinningLottoTest {

        @Test
        @DisplayName("당첨 로또인 경우 조회한다.")
        public void 당첨_로또인_경우_조회한다() {
            //given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 7;

            //when
            WinningLotto winningLotto = lotto.getWinningLotto(userLotto, bonusNumber);

            //then
            assertThat(winningLotto).isEqualTo(SIX);
        }

        @Test
        @DisplayName("보너스 로또인 경우 조회한다.")
        public void 보너스_로또인_경우_조회한다() {
            //given
            Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            int bonusNumber = 6;

            //when
            WinningLotto winningLotto = lotto.getWinningLotto(userLotto, bonusNumber);

            //then
            assertThat(winningLotto).isEqualTo(BONUS);
        }
    }

    @Test
    @DisplayName("번호가 로또 번호에 포함되는지 판단한다.")
    public void 번호가_로또_번호에_포함되는지_판단한다() {
        //given
        int containValue = 1;
        int nonContainValue = 7;
        Lotto lotto = new Lotto(List.of(containValue, 2, 3, 4, 5, 6));

        //when
        boolean containResult = lotto.contains(containValue);
        boolean nonContainResult = lotto.contains(nonContainValue);

        //then
        assertThat(containResult).isTrue();
        assertThat(nonContainResult).isFalse();
    }
}

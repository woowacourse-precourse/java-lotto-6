package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5))).isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @Nested
    @DisplayName("matchWinningLottoCount 메소드 test")
    class MatchWinningLottoCountTest {
        private Lotto lotto;

        @BeforeEach
        void beforeEach() {
            lotto = new Lotto(List.of(4, 8, 17, 26, 39, 40));
        }

        @DisplayName("당첨 번호와 발행된 로또를 비교하여 일치하는 숫자가 있다면 일치하는 개수를 반환한다.")
        @Test
        void matching_numbers_present() {
            // given
            WinningLotto winningLotto = new WinningLotto(List.of(4, 8, 17, 30, 41, 45));

            // when
            int matchedWinningLottoCount = lotto.matchWinningLottoCount(winningLotto);

            // then
            assertThat(matchedWinningLottoCount).isEqualTo(3);
        }

        @DisplayName("당첨 번호와 발행된 로또를 비교하여 일치하는 숫자가 없다면 0을 반환한다")
        @Test
        void matching_numbers_not_present() {
            // given
            WinningLotto winningLotto = new WinningLotto(List.of(1, 19, 23, 33, 42, 45));

            // when
            int matchedWinningLottoCount = lotto.matchWinningLottoCount(winningLotto);

            // then
            assertThat(matchedWinningLottoCount).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("hasBonusNumber 메소드 test")
    class HasBonusNumberTest {
        private Lotto lotto;
        private WinningLotto winningLotto;

        @BeforeEach
        void beforeEach() {
            lotto = new Lotto(List.of(4, 8, 17, 26, 39, 40));
            winningLotto = new WinningLotto(List.of(11, 23, 27, 31, 38, 43));
        }

        @DisplayName("발행된 로또에 보너스 숫자가 있다면 true 반환")
        @Test
        void Lotto_contain_bonus_number() {
            // given
            BonusNumber bonusNumber = new BonusNumber(45, winningLotto);

            // when
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

            // then
            assertThat(hasBonusNumber).isEqualTo(false);
        }

        @DisplayName("발행된 로또에 보너스 숫자가 없다면 false 반환")
        @Test
        void Lotto_not_contain_bonus_number() {
            // given
            BonusNumber bonusNumber = new BonusNumber(4, winningLotto);

            // when
            boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);

            // then
            assertThat(hasBonusNumber).isEqualTo(true);
        }
    }
}
package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.InvalidInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("WinningLotto 클래스")
class WinningLottoTest {

    @DisplayName("WinningLotto 객체 생성 테스트")
    @Test()
    void testCreateWinningLotto() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // then
        assertThat(winningLotto.getWinningNumbers()).isEqualTo(winningNumbers);
        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @DisplayName("WinningLotto 예외 테스트")
    @Nested
    class ExceptionTest {
        @DisplayName("보너스 번호가 범위를 벗어난 경우 - 초과")
        @Test
        void testBonusNumberOver() {
            // given
            Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 46;

            // when & then
            assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE).getMessage());

        }

        @DisplayName("보너스 번호가 범위를 벗어난 경우 - 미만")
        @Test
        void testBonusNumberUnder() {
            // given
            Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 0;

            // when & then
            assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE).getMessage());
        }

        @DisplayName("보너스 번호가 당첨 번호와 중복되는 경우")
        @Test
        void testBonusNumberDuplicated() {
            // given
            Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            int bonusNumber = 6;

            // when & then
            assertThatThrownBy(() -> new WinningLotto(winningNumbers, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(new InvalidInputException(ErrorMessage.LOTTO_NUMBERS_DUPLICATE).getMessage());
        }
    }

    @DisplayName("WinningLotto 로또 순위 반환 테스트")
    @Test
    void testWinningLottoRank() {
        // given
        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        // when & then
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 6)))).isEqualTo(LottoRank.FIRST);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 7)))).isEqualTo(LottoRank.SECOND);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 5, 8)))).isEqualTo(LottoRank.THIRD);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 4, 9, 8)))).isEqualTo(LottoRank.FOURTH);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 3, 10, 9, 8)))).isEqualTo(LottoRank.FIFTH);
        assertThat(winningLotto.match(new Lotto(List.of(1, 2, 11, 10, 9, 8)))).isEqualTo(LottoRank.NONE);
    }
}
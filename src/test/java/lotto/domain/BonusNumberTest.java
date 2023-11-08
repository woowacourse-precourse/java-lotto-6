package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("보너스 번호 도메인에")
class BonusNumberTest {

    @DisplayName("2등 당첨인지 확인 요청시")
    @Nested
    class CheckSecondWinning {

        @DisplayName("보너스 번호를 가진 경우 SECOND_GRADE를 반환한다.")
        @Test
        void secondWinning() {
            // given
            final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            final BonusNumber bonusNumber = new BonusNumber(1);

            // when
            final WinningGrade result = bonusNumber.checkSecondWinning(lotto);

            // then
            assertThat(result).isEqualTo(WinningGrade.SECOND_GRADE);
        }

        @DisplayName("보너스 번호를 갖지 않은 경우 THIRD_GRADE를 반환한다.")
        @Test
        void notSecondWinning() {
            // given
            final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
            final BonusNumber bonusNumber = new BonusNumber(7);

            // when
            final WinningGrade result = bonusNumber.checkSecondWinning(lotto);

            // then
            assertThat(result).isEqualTo(WinningGrade.THIRD_GRADE);
        }
    }

    @DisplayName("번호 값 확인 요청시 저장된 값을 반환한다.")
    @Test
    void toValue() {
        // given
        final int expected = 1;
        final BonusNumber bonusNumber = new BonusNumber(expected);

        // when
        final Integer result = bonusNumber.toValue();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("생성시")
    @Nested
    class CreateValidation {

        @Test
        @DisplayName("1보다 작은 값인 경우 예외를 던진다.")
        void lessThan1() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new BonusNumber(0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("45보다 큰 값인 경우 예외를 던진다.")
        void greaterThan45() {
            // given
            // when
            // then
            assertThatThrownBy(() -> new BonusNumber(46))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}

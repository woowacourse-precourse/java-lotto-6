package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.constant.WinningGrade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("우승 정보 도메인에")
class WinningDetailTest {

    @DisplayName("당첨 단계를 요청하면 저장된 당첨 단계를 반환한다.")
    @Test
    void toWinningGrade() {
        // given
        final WinningGrade expected = WinningGrade.FIRST_GRADE;
        final WinningDetail winningDetail = new WinningDetail(expected, 1);

        // when
        final WinningGrade result = winningDetail.toWinningGrade();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("인덱스를 요청하면 저장된 인덱스를 반환한다.")
    @Test
    void toIndex() {
        // given
        final int expected = 2;
        final WinningDetail winningDetail = new WinningDetail(WinningGrade.SECOND_GRADE, expected);

        // when
        final Integer result = winningDetail.toIndex();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("2등 여부 판단을 요청시")
    @Nested
    class ConvertIfSecondWinning {

        @DisplayName("보너스번호를 가진 경우 2등을 반환한다.")
        @Test
        void hasBonusNumber() {
            // given
            final int number = 3;
            final BonusNumber bonusNumber = new BonusNumber(number);
            final WinningDetail winningDetail = new WinningDetail(WinningGrade.THIRD_GRADE, 0);
            final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // when
            final WinningDetail result = winningDetail.convertIfSecondWinning(lotto, bonusNumber);

            // then
            assertThat(result.toWinningGrade()).isEqualTo(WinningGrade.SECOND_GRADE);
        }

        @DisplayName("보너스번호를 가지지 않은 경우 3등을 반환한다.")
        @Test
        void noBonusNumber() {
            // given
            final int number = 7;
            final BonusNumber bonusNumber = new BonusNumber(number);
            final WinningDetail winningDetail = new WinningDetail(WinningGrade.THIRD_GRADE, 0);
            final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            // when
            final WinningDetail result = winningDetail.convertIfSecondWinning(lotto, bonusNumber);

            // then
            assertThat(result.toWinningGrade()).isEqualTo(WinningGrade.THIRD_GRADE);
        }
    }

    @DisplayName("생성 요청시 인덱스가 음수인 경우 예외를 던진다.")
    @Test
    void createValidation() {
        // given
        // when
        // then
        assertThatThrownBy(() -> new WinningDetail(WinningGrade.FIRST_GRADE, -1));
    }
}

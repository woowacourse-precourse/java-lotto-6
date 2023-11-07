package lotto.model;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATED_WINNING_NUMBERS;
import static lotto.constant.ErrorMessage.NOT_IN_RANGE_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.LottoRanking;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoTest {

    @Nested
    @DisplayName("당첨번호와 보너스번호를 이용하여 당첨로또를 생성한다.")
    class createWinningLotto {

        @DisplayName("[성공] 당첨로또는 당첨번호와 보너스번호를 필드로 갖는다.")
        @Test
        void createWinningLottoGood() {
            // given
            Lotto lotto = createLotto();
            int bonusNumber = 7;

            // when
            WinningLotto result = WinningLotto.of(lotto, bonusNumber);

            // then
            assertThat(result).hasFieldOrPropertyWithValue("winningNumbers", lotto);
            assertThat(result).hasFieldOrPropertyWithValue("bonusNumber", bonusNumber);
        }

        @DisplayName("[실패] 보너스번호가 당첨번호와 중복되면 예외가 발생한다.")
        @Test
        void exceptionBonusNumberDuplicatedWinningNumbers() {
            // given
            Lotto lotto = createLotto();
            int bonusNumber = 6;

            // when
            assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BONUS_NUMBER_DUPLICATED_WINNING_NUMBERS.toString());
        }

        @DisplayName("[실패] 보너스번호가 로또 범위의 숫자가 아니면 예외가 발생한다.")
        @Test
        void exceptionBonusNumberNotInRange() {
            // given
            Lotto lotto = createLotto();
            int bonusNumber = 57;

            // when
            assertThatThrownBy(() -> WinningLotto.of(lotto, bonusNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(NOT_IN_RANGE_LOTTO_NUMBER.toString());
        }
    }

    @DisplayName("다른 로또와 비교하여 당첨 결과를 반환한다.")
    @MethodSource("generatedData")
    @ParameterizedTest
    void calculateLottoRanking(int bonusNumber, List<Integer> givenNumbers, LottoRanking expected) {
        // given
        Lotto winningNumbers = createLotto();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        Lotto userlotto = Lotto.from(givenNumbers);

        // when
        LottoRanking result = winningLotto.calculateLottoRanking(userlotto);

        // then
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> generatedData() {
        return Stream.of(
                Arguments.of(10, List.of(1, 2, 3, 7, 8, 9), LottoRanking.FIFTH),
                Arguments.of(10, List.of(1, 2, 3, 4, 8, 9), LottoRanking.FOURTH),
                Arguments.of(10, List.of(1, 2, 3, 4, 5, 9), LottoRanking.THIRD),
                Arguments.of(10, List.of(1, 2, 3, 4, 5, 10), LottoRanking.SECOND),
                Arguments.of(10, List.of(1, 2, 3, 4, 5, 6), LottoRanking.FIRST)
        );
    }

    private Lotto createLotto() {
        return Lotto.from(List.of(1, 2, 3, 4, 5, 6));
    }
}

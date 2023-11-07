package lotto.domain;

import lotto.config.ErrorMessage;
import lotto.config.WinningPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("보너스 번호가 범위를 벗어나면 예외가 발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void createWinningNumberByWrongBonus(int bonus) {
        Lotto numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumber(numbers, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.WRONG_BONUS_RANGE.message());
    }

    @DisplayName("보너스 번호가 기본 번호와 중복되면 예외가 발생")
    @Test
    void createWinningNumberByDuplicatedBonus() {
        Lotto numbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningNumber(numbers, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.DUPLICATED_BONUS.message());
    }

    @DisplayName("로또 당첨결과 확인")
    @ParameterizedTest
    @MethodSource("lottoAndResult")
    void compareLottoWithAnswer(Lotto target, WinningPrize result) {
        Lotto answerNumbers = new Lotto(List.of(17, 12, 9, 24, 36, 7));
        WinningNumber answer = new WinningNumber(answerNumbers, 32);
        assertThat(answer.compareWithLotto(target)).isEqualTo(result);
    }

    static Stream<Arguments> lottoAndResult() {
        return Stream.of(
                Arguments.of(new Lotto(List.of(13, 11, 8, 26, 3, 2)), null), // 0개
                Arguments.of(new Lotto(List.of(13, 12, 8, 26, 3, 2)), null), // 1개
                Arguments.of(new Lotto(List.of(13, 9, 12, 26, 32, 2)), null), // 2개
                Arguments.of(new Lotto(List.of(9, 13, 12, 24, 3, 32)), WinningPrize.FIFTH_PLACE), // 3개
                Arguments.of(new Lotto(List.of(17, 12, 9, 24, 3, 32)), WinningPrize.FOURTH_PLACE), // 4개
                Arguments.of(new Lotto(List.of(36, 24, 9, 12, 17, 2)), WinningPrize.THIRD_PLACE), // 5개
                Arguments.of(new Lotto(List.of(24, 36, 12, 9, 17, 32)), WinningPrize.SECOND_PLACE), // 5개 + 보너스
                Arguments.of(new Lotto(List.of(36, 24, 9, 7, 12, 17)), WinningPrize.FIRST_PLACE) // 6개
        );
    }
}

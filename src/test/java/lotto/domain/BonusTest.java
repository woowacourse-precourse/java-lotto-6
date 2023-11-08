package lotto.domain;

import static lotto.exception.Message.BONUS_NUMBER_DUPLICATION_EXCEPTION;
import static lotto.exception.Message.BONUS_NUMBER_RANGE_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusTest {

    private Lotto winnerLotto;

    @BeforeEach
    void setUp() {
        winnerLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("당첨 로또와 다른 숫자로 보너스 숫자를 만든다.")
    void create_bonus() {
        // given
        int number = 42;

        // when // then
        assertThatCode(() -> new Bonus(winnerLotto, number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자가 1 ~ 45 사이의 수가 아니라면 예외를 던진다.")
    @ValueSource(ints = {0, 46})
    void create_bonus_error_with_out_of_range(int bonusNumber) {
        // when // then
        assertThatThrownBy(() -> new Bonus(winnerLotto, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_RANGE_EXCEPTION);
    }

    @ParameterizedTest
    @DisplayName("보너스 숫자가 당첨 로또의 숫자와 겹치면 예외를 던진다.")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void create_bonus_error_with_duplication(int bonusNumber) {
        // when // then
        assertThatThrownBy(() -> new Bonus(winnerLotto, bonusNumber))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATION_EXCEPTION);
    }
}

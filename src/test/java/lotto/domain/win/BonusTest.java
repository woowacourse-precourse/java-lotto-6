package lotto.domain.win;

import static lotto.option.Error.ONE_TO_FORTY_FIVE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {
    @DisplayName("범위를 벗어나는 값을 입력했을 때 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void overRangeNumberThrowException(int number) {
        //given
        //when
        assertThatThrownBy(() -> new Bonus(number))
                //then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONE_TO_FORTY_FIVE.getMessage());
    }
}

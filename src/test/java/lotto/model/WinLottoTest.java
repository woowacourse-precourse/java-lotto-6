package lotto.model;

import static lotto.model.enums.ErrorMessage.DUPLICATED_NUMBER_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("우승 번호와 중복된 숫자 입력 예외 발생")
    void duplicateNumberInput(int input) {
        assertThatThrownBy(() -> new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(DUPLICATED_NUMBER_MESSAGE.getMessage());
    }
}
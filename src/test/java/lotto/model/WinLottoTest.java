package lotto.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.model.exceptions.DuplicatedNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinLottoTest {
    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("우승 번호와 중복된 숫자 입력 예외 발생")
    void duplicateNumberInputTest(int input) {
        assertThatThrownBy(() -> new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(input)))
                .isInstanceOf(DuplicatedNumberException.class);
    }

    @ParameterizedTest(name = "{index}: {0}")
    @ValueSource(ints = {41, 42, 43, 44, 45})
    @DisplayName("우승 번호와 중복되지 않은 숫자 입력 예외 발생X")
    void nonDuplicateNumberInputTest(int input) {
        assertThatCode(() -> new WinLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new BonusNumber(input)))
                .doesNotThrowAnyException();
    }
}
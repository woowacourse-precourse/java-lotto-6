package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumbersTest {
    private static final String NOT_IN_RIGHT_RANGE_ERROR_MESSAGE = "[ERROR] 각 자릿수는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨 번호와 중복되는 번호입니다.";
    
    private Lotto winningNumbers;
    
    @BeforeEach
    void setUp() {
        winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }
    
    @DisplayName("보너스 번호는 1 ~ 45 사이의 숫자여야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void bonusNumberBetweenOneAndFourtyFive(int bonusNumber) {
        // when // then
        assertThatThrownBy(() -> new Numbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_RIGHT_RANGE_ERROR_MESSAGE);
    }
    
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void bonusNumberNotDuplicatedWithWinningNumbers(int bonusNumber) {
        // when // then
        assertThatThrownBy(() -> new Numbers(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBER_ERROR_MESSAGE);
    }
}

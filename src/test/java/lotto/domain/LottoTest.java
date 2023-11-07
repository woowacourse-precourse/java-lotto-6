package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    private static final String OVER_SIZE_ERROR_MESSAGE = "[ERROR] 총 6개의 숫자로 구성되어야 합니다.";
    private static final String NOT_IN_RIGHT_RANGE_ERROR_MESSAGE = "[ERROR] 각 자릿수는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String DUPLICATED_NUMBERS_ERROR_MESSAGE = "[ERROR] 중복되는 숫자가 존재합니다.";
    
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        
        // when // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OVER_SIZE_ERROR_MESSAGE);
    }
    
    @DisplayName("로또 번호의 각 자릿수는 1 ~ 45 사이의 숫자이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 100})
    void createLottoByNumberInSpecifiedRange(int numberOutOfRange) {
        // given
        List<Integer> nonValidRangeNumbers = List.of(1, 2, 3, 4, 5, numberOutOfRange);
        
        // when // then
        assertThatThrownBy(() -> new Lotto(nonValidRangeNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_IN_RIGHT_RANGE_ERROR_MESSAGE);
    }
    
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void createLottoByDuplicatedNumber(int duplicatedNumber) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, duplicatedNumber);
        
        // when // then
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_NUMBERS_ERROR_MESSAGE);
    }
}

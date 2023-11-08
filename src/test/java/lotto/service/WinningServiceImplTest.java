package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.utils.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningServiceImplTest {
//    - [X] 중복된 숫자 입력 시 예외 발생 - 이미 Lotto의 validateDuplicate으로 구현함.
//            - [X] 숫자 입력 중 공백이 있다면 예외 발생 - 이미 Lotto의 validate() 가 역할을 하고 있다.
//            - 중간에 2,,4 와 같은 입력
//      - 처음에 ,4,2 와 같은 입력
//      - 마지막에 5, 와 같은 입력
//    - [X] 문자 입력 시 예외 발생
    WinningServiceImpl winningService = new WinningServiceImpl();

    @Test
    @DisplayName("중복된 숫자 입력 시 예외 발생")
    void winningNumberDuplicate() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 23, 28, 33, 24, 23);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.ERROR_DUPLICATE_LOTTO_NUMBER);
    }

    @Test
    @DisplayName("6개 이상 입력 시 예외 발생")
    void winningNumberCountOver() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 9, 3, 1, 32, 36);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개 이하 입력 시 예외 발생")
    void winningNumberCount() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 9, 3, 1);

        // When
        // Then
        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    @DisplayName("각 번호가 1 ~ 45 범위가 아니면 예외 발생")
    void winningNumberRange() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 89, 9, 3, 1);

        // When
        // Then

        assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningServiceImplTest {
    //    [X] 각 번호는 1 ~ 45 범위 이외 입력 시 예외 발생
//    - [X] 6개 이하 또는 6개 초과 입력 시 예외 발생 - 이미 Lotto의 validate가 구현되어 있음.
//    - [X] 중복된 숫자 입력 시 예외 발생 - 이미 Lotto의 validateDuplicate으로 구현함.
//            - [X] 숫자 입력 중 공백이 있다면 예외 발생 - 이미 Lotto의 validate() 가 역할을 하고 있다.
//            - 중간에 2,,4 와 같은 입력
//      - 처음에 ,4,2 와 같은 입력
//      - 마지막에 5, 와 같은 입력
//    - [X] 문자 입력 시 예외 발생
    WinningServiceImpl winningService = new WinningServiceImpl();

    @Test
    @DisplayName("각 번호가 1 ~ 45 범위가 아니면 예외 발생")
    void winningNumberRange() {
        // Given
        List<Integer> numbers = Arrays.asList(4, 34, 89, 9, 3, 1);

        // When
        // Then

        Assertions.assertThatThrownBy(() -> winningService.createWinningLotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
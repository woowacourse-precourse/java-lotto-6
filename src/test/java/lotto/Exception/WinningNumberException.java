package lotto.Exception;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.exception.WinningException.winningException;

public class WinningNumberException {
    @DisplayName("잘못된 당첨 숫자 예외 테스트")
    @Test
    void checkWinningNumberExceptionTest() {
        Assertions.assertThatThrownBy(() ->  winningException(List.of(1,2,3,4,5,46))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  winningException(List.of(1,2,3,4,5,0))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  winningException(List.of(1,2,3,4,5))).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThatThrownBy(() ->  winningException(List.of(1,2,3,4,5,5))).isInstanceOf(IllegalArgumentException.class);
    }
}

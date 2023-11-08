package lotto.dto;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberTest {
    @DisplayName("정답 번호의 개수가 6개가 넘어가면 예외 발생.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> WinningNumber.create("1,2,3,4,5,6,7"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("정답 번호에 중복된 숫자가 있으면 예외 발생.")
    @Test
    void createWinningNumberByDuplicatedNumber() {
        assertThatThrownBy(() -> WinningNumber.create("1,1,3,4,5,6"))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("null값 입력시 예외 발생")
    @Test
    void createWinningNumberByNull() {
        assertThatThrownBy(() -> WinningNumber.create(""))
                .isInstanceOf(LottoGameException.class);
    }

    @DisplayName("범위 밖 정수값 있을 시 예외 발생")
    @Test
    void createWinningNumberOverRange() {
        assertThatThrownBy(() -> WinningNumber.create("1,2,3,4,5,46"))
                .isInstanceOf(LottoGameException.class);
    }
}

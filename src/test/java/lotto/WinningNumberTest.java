package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import lotto.PrintError;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class WinningNumberTest {
    @DisplayName("당첨번호 개수가 6개 넘어가면 예외가 발생한다.")
    @Test
    void createWinningNumberByOverSize() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(PrintError.countERROR());
    }

    @DisplayName("당첨 번호 중복된 입력 값이 있으면 예외가 발생한다.")
    @Test
    void createWinningNumberByDuplicatedInput() {
        assertThatThrownBy(() -> new WinningNumber("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(PrintError.duplicateError());
    }
    @DisplayName("당첨 번호 입력 값이 없으면 예외가 발생한다.")
    @Test
    void createWinningNumberByNoInput() {
        assertThatThrownBy(() -> new WinningNumber(""))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(PrintError.nullException());
    }
    @DisplayName("당첨 번호 정수가 아닌 입력 값이 없으면 예외가 발생한다.")
    @Test
    void createWinningNumberByWrongInput() {
        assertThatThrownBy(() -> new WinningNumber("DD"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(PrintError.decimalException());
    }
    @DisplayName("당첨 번호 잘못된 범위의 입력 값이 없으면 예외가 발생한다.")
    @Test
    void createWinningNumberByRangeOver() {
        assertThatThrownBy(() -> new WinningNumber("46,47,48,49,50,51"))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining(PrintError.rangeError());
    }


}

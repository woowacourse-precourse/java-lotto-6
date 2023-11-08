package lotto;

import domain.LottoDraw;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoDrawTest {

    @Test
    @DisplayName("숫자 혹은 구분자가 아닌 입력이 있으면 예외발생")
    public void testInputContainsNumberOrSplitter() {
        LottoDraw lottoDraw = new LottoDraw();
        assertThatThrownBy(() -> lottoDraw.winNumbers("이것은 숫자나 구분자가 아님")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자");
    }

    @Test
    @DisplayName("당첨번호가 6개가 아니면 예외발생")
    public void testInputLengthIsNotSix() {
        LottoDraw lottoDraw = new LottoDraw();
        assertThatThrownBy(() -> lottoDraw.winNumbers("1,2,3,4,5,6,7")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("6");
    }

    @Test
    @DisplayName("당첨번호 입력 형식중 구분자(,)가 올바른위치에 있지 않으면 예외발생")
    public void testValidateInputBySide() {
        LottoDraw lottoDraw = new LottoDraw();
        assertThatThrownBy(() -> lottoDraw.winNumbers(",1,2,3,4,5")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력의 시작과 끝은");
    }

    @Test
    @DisplayName("당첨번호 중 범위를 벗어나는 번호가 있으면 예외발생")
    public void testValidateInRange() {
        LottoDraw lottoDraw = new LottoDraw();
        assertThatThrownBy(() -> lottoDraw.winNumbers("1,2,3,4,5,100")).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("로또 번호는 1부터");
    }
}



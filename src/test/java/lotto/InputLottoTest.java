package lotto;

import lotto.input.InputLottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputLottoTest {

    @DisplayName("사용자가 알파벳을 입력하면 예외가 발생한다. ")
    @Test
    void createInputAlphabet() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new InputLottoValidator("1,2,3,d,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 특수문자를 입력하면 예외가 발생한다.")
    @Test
    void createInputSpecialCharacter() {
        assertThatThrownBy(() -> new InputLottoValidator("1,2,3,;,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 빈 문자열을 입력하면 예외가 발생한다.")
    @Test
    void createInputBlank() {
        assertThatThrownBy(() -> new InputLottoValidator(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

}

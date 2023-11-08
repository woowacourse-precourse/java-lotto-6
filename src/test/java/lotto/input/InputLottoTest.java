package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.input.validator.InputLottoValidator.getInstance;

public class InputLottoTest {
    @AfterEach
    public void afterEach(){
        Console.close();
    }
    @DisplayName("사용자가 알파벳을 입력하면 예외가 발생한다. ")
    @Test
    void createInputAlphabet() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> getInstance().validate("1,2,3,d,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 특수문자를 입력하면 예외가 발생한다.")
    @Test
    void createInputSpecialCharacter() {
        assertThatThrownBy(() -> getInstance().validate("1,2,3,;,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 빈 문자열을 입력하면 예외가 발생한다.")
    @Test
    void createInputBlank() {
        assertThatThrownBy(() -> getInstance().validate(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자가 올바른 값을 입력하면 입력한 값이 그대로 반환된다.")
    @Test
    void createInputSuccess() {
        String input = "1,2,3,4,5,6";
        String result;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        InputLotto inputLotto = new InputLotto();

        System.setIn(in);
        result = inputLotto.getUserInput();

        Assertions.assertEquals(input, result);
    }
}

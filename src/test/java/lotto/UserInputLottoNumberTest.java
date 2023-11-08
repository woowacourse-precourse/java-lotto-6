package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.UserInput;
import org.junit.jupiter.api.Test;

public class UserInputLottoNumberTest {
    @Test
    void 로또_번호_입력_테스트() {
        String input = "1,2,3,4,5,6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        userInput.lottoNumber().forEach(lottoNumber -> assertThat(lottoNumber).isInstanceOf(Integer.class));
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 로또_번호_입력_테스트_공백포함() {
        String input = "1, 2, 3 ,4 ,5, 6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        userInput.lottoNumber().forEach(lottoNumber -> assertThat(lottoNumber).isInstanceOf(Integer.class));
        System.setIn(System.in);
        Console.close();
    }

    @Test
    void 숫자가_아님() {
        String input = "1,o,3,4,5,6";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        UserInput userInput = new UserInput();
        assertThatThrownBy(userInput::lottoNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 해주세요.");
        System.setIn(System.in);
        Console.close();
    }
}

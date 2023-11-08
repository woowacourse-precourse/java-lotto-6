package lotto.input;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import lotto.view.InputBonusNumberView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputBonusNumberViewTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("보너스 번호 입력 시 빈 값이 들어오면 에러")
    @Test
    void checkEmpty() {
        String input = "\0";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputBonusNumberView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호 입력 시 숫자가 아닌 값이 들어오면 에러")
    @Test
    void checkNumber() {
        String input = "aa";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(InputBonusNumberView::inputBonusNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("추가번호 입력 성공")
    @Test
    void checkSuccess() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = InputBonusNumberView.inputBonusNumber();

        assertThat(result).isEqualTo(1);
    }

}

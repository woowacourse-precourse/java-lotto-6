package lotto;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

class InputManagerTest {

    @Test
    void 보너스_번호_입력() {
        String input = "34";
        setInput(input);

        assertThat(InputManager.bonusNumberInput(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 구매_금액_입력() {
        String input = "10000";
        setInput(input);

        assertThat(InputManager.purchaseAmountInput()).isEqualTo(10000);

        Console.close();
    }

    @Test
    void 당첨_로또_숫자가_아니면_예외() {
        String input = "1, 2, 3, a, 4, 5";
        setInput(input);

        assertThatThrownBy(() -> InputManager.winningLottoInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 숫자를 입력해야 합니다.");

        Console.close();
    }

    @Test
    void 당첨_로또_입력_받기() {
        String input = " 1, 3, 4, 5, 6, 7";
        setInput(input);

        assertThat(InputManager.winningLottoInput()).contains(1, 3, 4, 5, 6, 7);

        Console.close();
    }

    @Test
    void 입력_공백_제거() {
        String input = "  12,  3 4 5, 55, 11   ";
        setInput(input);

        assertThat(InputManager.receiveUserInput()).isEqualTo("12,345,55,11");

        Console.close();
    }

    void setInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
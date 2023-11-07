package lotto;

import camp.nextstep.edu.missionutils.Console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest{
    InputView view = new InputView();

    @Test
    void 로또_구입_금액_입력_테스트() {
        command("100d");
        assertThatThrownBy(() -> view.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_외의_당첨_번호_입력_테스트() {
        command("46,1,2,3,4,5", "0,1,2,3,4,5");
        assertThatThrownBy(() -> view.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> view.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_개수_오입력_테스트() {
        command("1,2,3,4,5,6,7");
        assertThatThrownBy(() -> view.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_당첨_번호_입력_테스트() {
        command("1,2,3,4,5,e");
        assertThatThrownBy(() -> view.inputWinningNumbers())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_보너스_번호_입력_테스트() {
        command("test");
        assertThatThrownBy(() -> view.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 범위_외의_보너스_번호_입력_테스트() {
        command("46", "0");
        assertThatThrownBy(() -> view.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> view.inputBonusNumber())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @AfterEach
    private void closeConsole() {
        Console.close();
    }
}

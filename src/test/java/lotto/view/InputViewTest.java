package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        command("string", "a", "-", "", null, " ", "3 02", "12");
    }

    @DisplayName("로또 구입 금액이 숫자가 아니면 숫자를 입력받을 때까지 재입력한다.")
    @Test
    void inputPriceUntilNumber() {
        int actual = inputView.inputPrice();
        assertThat(actual).isEqualTo(12);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}

package lotto;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest{
    InputView view = new InputView();
    
    @Test
    void 로또_구입_금액_입력_테스트() {
        command("100d");
        assertThatThrownBy(() -> {
            view.inputPurchaseAmount();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}

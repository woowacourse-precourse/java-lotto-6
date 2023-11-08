package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import lotto.view.Input;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputBonusNumberTest extends NsTest {
    Input input = new Input();

    @Test
    @DisplayName("유효한 보너스 번호 입력 테스트")
    void getValidBonusNumber_test() {
        command("7");

        assertThat(input.getValidBonusNumber()).isEqualTo(7);

    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    @Override
    protected void runMain() {
        input.getValidBonusNumber();
    }
}

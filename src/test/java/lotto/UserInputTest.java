package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class UserInputTest extends NsTest {
    @DisplayName("사용자 입력 테스트")
    @Test
    void inputPrice_test() {
        // given
        ByteArrayInputStream in = new ByteArrayInputStream("4000".getBytes());
        System.setIn(in);

        // when/then
        assertThatCode(UserInput::inputPrice).doesNotThrowAnyException();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}

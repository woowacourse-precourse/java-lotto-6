package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import InputManager.InputManager;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputManagerTest {
    private InputStream stdIn;

    @BeforeEach
    void setUp() {
        stdIn = System.in;
    }
    @AfterEach
    void resetSysinStream() {
        System.setIn(stdIn);
    }
    @DisplayName("구입 금액을 입력받는 테스트.")
    @Test
    void inputCost_테스트() {
        String inputData = "1000";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputCost()).isEqualTo(1000);
    }

    @DisplayName("부정확한 입력을 받았을 때 다시 입력을 받는지 테스트.")
    @Test
    void inputCost_예외_테스트() {
        String inputData = "1200\n1300\n01000\n1000";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputCost()).isEqualTo(1000);
    }

    // 아래에 추가 테스트 작성 가능
}
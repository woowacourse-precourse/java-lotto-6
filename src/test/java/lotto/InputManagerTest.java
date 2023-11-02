package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputManagerTest {

    @Test
    void 입력_공백_제거() {
        String input = "  12,  3 4 5, 55, 11   ";

        assertThat(InputManager.removeInputSpace(input)).isEqualTo("12,345,55,11");
    }
}
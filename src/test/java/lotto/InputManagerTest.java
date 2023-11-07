package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import InputManager.InputManager;
import camp.nextstep.edu.missionutils.Console;
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
        Console.close();
        System.setIn(stdIn);
    }

    @DisplayName("구입 금액을 입력받는 테스트.")
    @Test
    void inputCost_테스트() {
        String inputData = "1000";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputCost()).isEqualTo(1000);
    }

    @DisplayName("부정확한 구입금액 입력을 받았을 때 다시 입력을 받는지 테스트.")
    @Test
    void inputCost_예외_테스트() {
        String inputData = "1200\n1300\n01000\n1000";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputCost()).isEqualTo(1000);
    }

    @DisplayName("당첨 번호를 입력받는 테스트.")
    @Test
    void inputWinningNumberList_테스트() {
        String inputData = "1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("부정확한 당첨 번호를 입력을 받았을 때 다시 입력을 받는지 테스트.")
    @Test
    void inputWinningNumberList_예외_테스트() {
        String inputData = "1,2,3,4,5,60\n1.5,2,3,4,5,6\n1,-2,3,4,5,6\n0,2,3,4,5,6\n1,2,3,4,5,6,7\n1,2,3,4,5,6";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputWinningNumbers())
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("보너스 번호를 입력받는 테스트.")
    @Test
    void inputBonusNumber_테스트() {
        String inputData = "40";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputBonusNumber(List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(40);
    }

    @DisplayName("부정확한 보너스 번호를 입력을 받았을 때 다시 입력을 받는지 테스트.")
    @Test
    void inputBonusNumber_예외_테스트() {
        String inputData = "0\n60\n-2\n2.5\n5\n1\n40";
        System.setIn(new ByteArrayInputStream(inputData.getBytes()));

        assertThat(InputManager.inputBonusNumber(List.of(1, 2, 3, 4, 5, 6)))
                .isEqualTo(40);
    }

    // 아래에 추가 테스트 작성 가능
}
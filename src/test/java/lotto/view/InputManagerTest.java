package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class InputManagerTest {
    private final InputManager inputManager = InputManager.getInstance();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @DisplayName("복권 구입 금액을 입력 받는다.")
    @Test
    void getPurchaseAmount() {
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputManager.getPurchaseAmount()).isEqualTo(8);
    }

    @DisplayName("입력받은 당첨번호를 정수 리스트 형태로 얻는다.")
    @Test
    void getWinningNumbers() {
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        List<Integer> result = inputManager.getWinningNumbers();

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result).isEqualTo(expectedNumbers);
    }

    @DisplayName("입력받은 보너스 번호를 정수 형태로 얻는다.")
    @Test
    void getBonusNumber() {
        String input = "7";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = inputManager.getBonusNumber();

        assertThat(result).isEqualTo(7);
    }
}
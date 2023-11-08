package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    @AfterEach
    void teardown() {
        Mockito.framework().clearInlineMocks();
    }

    @Test
    void 구입금액_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "5000";
        mockConsoleReadLine(input);

        // Act
        int purchase = inputView.getPurchase();

        // Assert
        assertEquals(5000, purchase);
    }

    @Test
    void 구입금액_1천원_단위_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1500";
        mockConsoleReadLine(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getPurchase();
        });
    }

    @Test
    void 당첨번호_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,6";
        mockConsoleReadLine(input);

        // Act
        var winNumbers = inputView.getWinNumbers();

        // Assert
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winNumbers);
    }

    @Test
    void 당첨번호_5개_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1 2 3 4 5";
        mockConsoleReadLine(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getWinNumbers();
        });
    }

    @Test
    void 보너스번호_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "7";
        mockConsoleReadLine(input);

        // Act
        int bonusNumber = inputView.getBonusNumbers();

        // Assert
        assertEquals(7, bonusNumber);
    }

    @Test
    void 보너스_번호_숫자_입력_테스트() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("42\n".getBytes())); // 보너스 번호를 42로 입력
        int bonusNumber = inputView.getBonusNumbers();
        assertEquals(42, bonusNumber);
    }

    @Test
    void 보너스번호_1부터_45_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "7"; // 1부터 45 사이의 숫자
        mockConsoleReadLine(input);

        // Act
        int bonusNumber = inputView.getBonusNumbers();

        // Assert
        assertEquals(7, bonusNumber);
    }

    @Test
    void 보너스번호_46_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "46"; // 46은 유효하지 않은 숫자
        mockConsoleReadLine(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getBonusNumbers();
        });
    }

    @Test
    void 당첨번호_1부터_45_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,6"; // 1부터 45 사이의 숫자들
        mockConsoleReadLine(input);

        // Act
        List<Integer> winNumbers = inputView.getWinNumbers();

        // Assert
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), winNumbers);
    }

    @Test
    void 당첨번호_46_입력_테스트() {
        // Arrange
        InputView inputView = new InputView();
        String input = "1,2,3,4,5,46"; // 46은 유효하지 않은 숫자
        mockConsoleReadLine(input);

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> {
            inputView.getWinNumbers();
        });
    }

    private void mockConsoleReadLine(String input) {
        Mockito.mockStatic(Console.class);
        Mockito.when(Console.readLine()).thenReturn(input);
    }
}

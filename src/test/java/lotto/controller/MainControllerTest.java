package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MainControllerTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();
    private MainController mainController;

    private

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        mainController = new MainController();
    }

    @DisplayName("로또 전체 컨트롤러를 테스트한다.")
    @Test
    void testWinningController() {
        String money = "8000";
        String lotto = "1,2,3,4,5,6";
        String bonus = "7";
        String[] args = {money, lotto, bonus};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));

        mainController.run();

        String testResult = outputStream.toString().trim();
        String playerLotto = "8개를 구매했습니다.";
        String playerResult = "당첨 통계";
        assertThat(testResult).contains(playerLotto, playerResult);
    }
}
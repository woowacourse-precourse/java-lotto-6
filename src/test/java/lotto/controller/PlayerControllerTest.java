package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.model.lotto.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerControllerTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();
    private PlayerController playerController;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        playerController = new PlayerController();
    }

    @DisplayName("사용자 컨트롤러를 테스트한다.")
    @Test
    void 사용자_컨트롤러_테스트() {
        String money = "8000";
        System.setIn(new ByteArrayInputStream(money.getBytes()));

        Player player = playerController.createPlayer();
        assertThat(player).isNotNull();

        playerController.showPlayerLotto(player);

        String testResult = outputStream.toString().trim();
        String playerLotto = "8개를 구매했습니다.";
        assertThat(testResult).contains(playerLotto);
    }
}
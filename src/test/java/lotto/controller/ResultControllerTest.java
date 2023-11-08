package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Player;
import lotto.model.lotto.Winning;
import lotto.model.result.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultControllerTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();
    private PlayerController playerController;
    private WinningController winningController;
    private ResultController resultController;
    private Player player;
    private Result result;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        playerController = new PlayerController();
        winningController = new WinningController();
        resultController = new ResultController();
    }

    @DisplayName("로또 당첨 결과 컨트롤러를 테스트한다.")
    @Test
    void 로또_당첨_결과_컨트롤러_테스트() {
        testCreateResult();
        testShowResult();
    }

    private void testCreateResult() {
        String money = "8000";
        String lotto = "1,2,3,4,5,6";
        String bonus = "7";
        String[] args = {money, lotto, bonus};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));

        player = playerController.createPlayer();
        Lotto winningLotto = winningController.createWinningLotto();
        Winning winning = winningController.createWinning(winningLotto);

        result = resultController.createResult(player, winning);
        assertThat(result).isNotNull();
    }

    private void testShowResult() {
        resultController.showResult(result, player);

        String testResult = outputStream.toString().trim();
        String playerResult = "당첨 통계";
        assertThat(testResult).contains(playerResult);
    }
}
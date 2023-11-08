package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Winning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningControllerTest {
    private final OutputStream outputStream = new ByteArrayOutputStream();
    private WinningController winningController;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
        winningController = new WinningController();
    }

    @DisplayName("로또 당첨 번호 컨트롤러를 테스트한다.")
    @Test
    void 로또_당첨_번호_컨트롤러를_테스트() {
        testCreateWinningLotto();
        testCreateWinning();
    }

    private void testCreateWinningLotto() {
        String lotto = "1,2,3,4,5,6";
        String bonus = "7";
        String[] args = {lotto, bonus};
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));

        winningLotto = winningController.createWinningLotto();
        assertThat(winningLotto).isNotNull();
    }

    private void testCreateWinning() {
        Winning winning = winningController.createWinning(winningLotto);

        assertThat(winning).isNotNull();
    }
}
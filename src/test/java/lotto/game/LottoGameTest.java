package lotto.game;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.common.ConsoleTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest extends ConsoleTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("입력 받은 로또 구입 가격이 숫자가 아니면 에러 메시지를 출력한다.")
    @Test
    void initCostByNonNumber() {
        // given
        setStdin("\n", "a", "1000", "1,2,3,4,5,6", "30");

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.init();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(LottoGameMessage.NON_NUMBER.getMessage());
    }

    @DisplayName("입력 받은 로또 구입 가격가 범위를 벗어나면 에러 메시지를 출력한다.")
    @Test
    void initCostByOutOfRange() {
        // given
        setStdin("\n", "100", "1000", "1,2,3,4,5,6", "30");

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.init();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(LottoGameMessage.NUMBER_OUT_OF_RANGE.getMessage());
    }
}

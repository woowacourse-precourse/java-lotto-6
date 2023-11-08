package lotto.game;

import static lotto.game.LottoGameMessage.INVALID_COST_UNIT;
import static lotto.game.LottoGameMessage.INVALID_LOTTO_NUMBERS;
import static lotto.game.LottoGameMessage.NON_NUMBER;
import static lotto.game.LottoGameMessage.NUMBER_OUT_OF_RANGE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.common.ConsoleTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameTest extends ConsoleTest {
    @DisplayName("로또 게임 초기 설정 에러 메시지 테스트")
    @ParameterizedTest(name = "입력이 {0}일 때 {1} 에러 메시지를 출력한다.")
    @MethodSource("initSource")
    void initErrorMessage(String[] input, LottoGameMessage message) {
        // given
        setStdin("\n", input);

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.init();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(message.getMessage());
    }

    public static Stream<Arguments> initSource() {
        return Stream.of(
                Arguments.of(new String[]{"a", "1000", "1,2,3,4,5,6", "30"}, NON_NUMBER),
                Arguments.of(new String[]{"555", "1000", "1,2,3,4,5,6", "30"}, INVALID_COST_UNIT),
                Arguments.of(new String[]{"1000", "a,2,3,4,5,6", "1,2,3,4,5,6", "30"}, NON_NUMBER),
                Arguments.of(new String[]{"1000", "1,1,3,4,5,6", "1,2,3,4,5,6", "30"}, INVALID_LOTTO_NUMBERS),
                Arguments.of(new String[]{"1000", "1,2,3,4,5", "1,2,3,4,5,6", "30"}, INVALID_LOTTO_NUMBERS),
                Arguments.of(new String[]{"1000", "1,2,3,4,5,6,7", "1,2,3,4,5,6", "30"}, INVALID_LOTTO_NUMBERS),
                Arguments.of(new String[]{"1000", "1,2,3,4,5,6", "a", "30"}, NON_NUMBER),
                Arguments.of(new String[]{"1000", "1,2,3,4,5,6", "0", "30"}, NUMBER_OUT_OF_RANGE),
                Arguments.of(new String[]{"1000", "1,2,3,4,5,6", "50", "30"}, NUMBER_OUT_OF_RANGE)
        );
    }
}

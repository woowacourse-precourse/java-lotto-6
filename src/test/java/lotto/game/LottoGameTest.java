package lotto.game;

import static lotto.game.LottoGameMessage.INVALID_COST_UNIT;
import static lotto.game.LottoGameMessage.INVALID_LOTTO_NUMBERS;
import static lotto.game.LottoGameMessage.NON_NUMBER;
import static lotto.game.LottoGameMessage.NUMBER_OUT_OF_RANGE;
import static lotto.game.LottoGameMessage.PURCHASE_LOTTOS_FORMATTER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import lotto.common.ConsoleTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoGameTest extends ConsoleTest {
    @DisplayName("구입 가격 입력 에러 메시지 테스트")
    @ParameterizedTest(name = "입력이 {0}일 때 {1} 에러 메시지를 출력한다.")
    @MethodSource("initCostSource")
    void initCostErrorMessage(String[] input, LottoGameMessage message) {
        // given
        setStdin("\n", input);

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.initCost();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(message.getMessage());
    }

    @DisplayName("당첨 로또 입력 에러 메시지 테스트")
    @ParameterizedTest(name = "입력이 {0}일 때 {1} 에러 메시지를 출력한다.")
    @MethodSource("initTargetSource")
    void initTargetErrorMessage(String[] input, LottoGameMessage message) {
        // given
        setStdin("\n", input);

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.initTarget();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(message.getMessage());
    }

    @DisplayName("보너스 번호 입력 에러 메시지 테스트")
    @ParameterizedTest(name = "입력이 {0}일 때 {1} 에러 메시지를 출력한다.")
    @MethodSource("initBonusNumberSource")
    void initBonusNumberErrorMessage(String[] input, LottoGameMessage message) {
        // given
        setStdin("\n", input);

        LottoGame lottoGame = new LottoGame();

        // when
        lottoGame.initBonusNumber();

        // then
        String stdout = getStdout();

        assertThat(stdout).contains(message.getMessage());
    }

    @DisplayName("구입한 로또 개수를 출력한다.")
    @Test
    void purchaseLottos() {
        setStdin("\n", "10000");

        LottoGame lottoGame = new LottoGame();

        lottoGame.initCost();

        // when
        lottoGame.purchaseLottos();

        // then
        String stdout = getStdout();
        String formatterMessage = PURCHASE_LOTTOS_FORMATTER.getMessage();

        assertThat(stdout).contains(formatterMessage.formatted(10));
    }

    public static Stream<Arguments> initCostSource() {
        return Stream.of(Arguments.of(new String[]{"a", "1000"}, NON_NUMBER),
                Arguments.of(new String[]{"555", "1000"}, INVALID_COST_UNIT));
    }

    public static Stream<Arguments> initTargetSource() {
        return Stream.of(Arguments.of(new String[]{"a,2,3,4,5,6", "1,2,3,4,5,6"}, NON_NUMBER),
                Arguments.of(new String[]{"1,1,3,4,5,6", "1,2,3,4,5,6"}, INVALID_LOTTO_NUMBERS),
                Arguments.of(new String[]{"1,2,3,4,5", "1,2,3,4,5,6"}, INVALID_LOTTO_NUMBERS),
                Arguments.of(new String[]{"1,2,3,4,5,6,7", "1,2,3,4,5,6"}, INVALID_LOTTO_NUMBERS));
    }

    public static Stream<Arguments> initBonusNumberSource() {
        return Stream.of(Arguments.of(new String[]{"a", "30"}, NON_NUMBER),
                Arguments.of(new String[]{"0", "30"}, NUMBER_OUT_OF_RANGE),
                Arguments.of(new String[]{"50", "30"}, NUMBER_OUT_OF_RANGE));
    }
}

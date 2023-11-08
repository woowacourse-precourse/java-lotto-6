package lotto.unitTest.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.LottoGameController;
import lotto.view.OutputMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameControllerTest extends NsTest {
    private static final String LOTTO_COST = "1000";
    private static final String WINNING_NUMBERS = "1,2,3,4,5,6";
    private static final int REPRINTED_COUNT_NUMBER = 2;

    private static LottoGameController createLottoGameController() {
        return new LottoGameController();
    }

    private int countMatchMessage(String output, String message) {
        return (output.length() - output.replace(message, "").length()) / message.length();
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "10", "abc", "1234", "-1000"})
    void 잘못된_로또_구입_금액을_입력하면_입력_안내_메시지를_다시_출력한다(String userInputLottoCost) {
        assertSimpleTest(() -> {
            runException(userInputLottoCost);

            assertThat(countMatchMessage(output(), OutputMessage.REQUEST_LOTTO_COST.getMessage()))
                    .isEqualTo(REPRINTED_COUNT_NUMBER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "a,b,c,d,e,f", "-1,2,3,4,5,6", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    void 잘못된_당첨_번호를_입력하면_입력_안내_메시지를_다시_출력한다(String userInputWinningNumber) {
        assertSimpleTest(() -> {
            runException(LOTTO_COST, userInputWinningNumber);

            assertThat(countMatchMessage(output(), OutputMessage.REQUEST_WINNING_NUMBERS.getMessage()))
                    .isEqualTo(REPRINTED_COUNT_NUMBER);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n", "a", "6", "0", "46"})
    void 잘못된_보너스_번호를_입력하면_입력_안내_메시지를_다시_출력한다(String userInputBonusNumber) {
        assertSimpleTest(() -> {
            runException(LOTTO_COST, WINNING_NUMBERS, userInputBonusNumber);

            assertThat(countMatchMessage(output(), OutputMessage.REQUEST_BONUS_NUMBER.getMessage()))
                    .isEqualTo(REPRINTED_COUNT_NUMBER);
        });
    }

    @Override
    public void runMain() {
        createLottoGameController().gameStart();
    }
}
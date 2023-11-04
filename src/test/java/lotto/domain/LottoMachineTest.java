package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.validation.LottoMachineValidationHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {

    LottoMachine lottoMachine = new LottoMachine();

    @ParameterizedTest
    @CsvSource(value = {"1:1","2:2","5:5", "10:10", "100:100"}, delimiter = ':')
    @DisplayName("구매 갯수가 1개 이상일 때 구매 갯수 만큼 로또를 발행한다.")
    void generateLottos(int userPurchaseCount, int generateLottoCount) {
        // given // when
        List<Lotto> lottos = lottoMachine.generateLottos(userPurchaseCount);

        // then
        assertThat(lottos).hasSize(generateLottoCount);
    }

    @Test
    @DisplayName("구매 갯수가 0개이면 로또를 발행할 때 예외가 발생한다.")
    void generateLottosException() {
        // given
        int purchaseLottoCount = 0;

        // when // then
        assertThatThrownBy(() -> lottoMachine.generateLottos(purchaseLottoCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoMachineValidationHandler.INVALID_LOTTO_GENERATE_COUNT_MESSAGE);
    }

    @Test
    @DisplayName("입력받은 당첨 번호를 쉼표(,)로 분류할 때 중복되지 않은 1~45 사이의 6자리 숫자이면 예외가 발생하지 않는다.")
    void registerWinningNumber() {
        // given
        String winningNumber = "1,2,3,15,30,45";

        // when
        List<Integer> winningNumbers = lottoMachine.registerWinningNumber(winningNumber);

        // then
        assertThat(winningNumbers).hasSize(6)
                .containsSequence(1, 2, 3, 15, 30, 45);
    }

    @ParameterizedTest
    @MethodSource("invalidWinningNumber")
    @DisplayName("입력받은 보너스 번호를 쉼표(,)로 분류할 때 중복되지 않은 1~45 사이의 6자리 숫자가 아니면 예외가 발생한다.")
    void registerWinningNumberException(String winningNumber) {
        // given // when // then
        assertThatThrownBy(() -> lottoMachine.registerWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<String> invalidWinningNumber() {
        return Stream.of("1,2,3,4,15,30,45",
                "0,2,3,15,30,45",
                "1,2,3,15,30,46",
                "1,a,3,15,30,45",
                "1,.,3,15,30,45",
                "1,이,3,15,30,45"
        );
    }
}
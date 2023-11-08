package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "10", "20", "30", "40", "45"})
    @DisplayName("1~45 사이의 보너스 번호를 저장한다.")
    void registerBonusNumber(String bonusNumber) {
        // given // when // then
        lottoMachine.registerBonusNumber(bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "일", "a", " ", ".", "?"})
    @DisplayName("1~45 사이의 보너스 번호가 아니면 예외가 발생한다.")
    void registerBonusNumberException(String bonusNumber) {
        // given // when // then
        assertThatThrownBy(() -> lottoMachine.registerBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호와 보너스 번호 당첨 번호를 이용해서 로또 당첨 내역을 계산한다.")
    void computedLottoRanking() {
        // given
        List<Lotto> lottos = getLottos();
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        Map<LottoRank, Integer> ranking = lottoMachine.computedLottoRanking(lottos, winningNumbers, bonusNumber);

        // then
        assertThat(ranking).hasSize(6)
                .containsEntry(LottoRank.FIRST_PRIZE, 0)
                .containsEntry(LottoRank.SECOND_PRIZE, 0)
                .containsEntry(LottoRank.THIRD_PRIZE, 0)
                .containsEntry(LottoRank.FOURTH_PRIZE, 0)
                .containsEntry(LottoRank.FIFTH_PRIZE, 1)
                .containsEntry(LottoRank.NONE_PRIZE, 7);
    }

    private static List<Lotto> getLottos() {
        Lotto lotto1 = new Lotto(List.of(8, 21, 23, 41, 42, 43));
        Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
        Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
        Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
        Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
        Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
        Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
        Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));

        return List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8);
    }

    @Test
    @DisplayName("소수점 둘째 자리에서 반올림하여 수익률을 계산한다.")
    void computedYieldRate() {
        // given
        int purchaseAmount = 8_000;
        Map<LottoRank, Integer> lottoRanks = Map.of(LottoRank.FIFTH_PRIZE, 1);

        // when
        double yieldRate = lottoMachine.computedYieldRate(purchaseAmount, lottoRanks);

        // then
        assertThat(yieldRate).isEqualTo(62.5);
    }
}
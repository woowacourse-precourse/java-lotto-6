package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottogenerator.LottoGenerator;
import lotto.domain.money.Money;
import lotto.domain.ranking.LottoRanking;
import lotto.domain.statistic.Statistic;
import lotto.domain.winninglotto.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    @DisplayName("LottoGenerator를 입력받아 생성한다.")
    @Test
    void createWithLottoGenerator() {
        // given
        LottoGenerator lottoGenerator = new TestLottoGenerator();

        // when
        LottoService lottoService = LottoService.init(lottoGenerator);

        // then
        assertThat(lottoService).isInstanceOf(LottoService.class);
    }

    @DisplayName("입력 받은 금맥 만큼의 Money를 생성할 수 있다.")
    @Test
    void createMoney() {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());
        int value = 5000;

        // when
        Money money = lottoService.createMoney(value);

        // then
        assertThat(money.getValue()).isEqualTo(value);
    }

    @DisplayName("입력한 금액이 유효하지 않는 경우 예외를 발생한다.")
    @Test
    void createMoneyByInvalidValue() {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());
        int value = -5000;

        // when
        assertThatThrownBy(() -> lottoService.createMoney(value))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액 만큼 로또를 구매할 수 있다.")
    @Test
    void purchaseLottosForInputPrice() {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());
        Money money = Money.valueOf(5000);

        // when
        List<Lotto> lottos = lottoService.purchaseLotto(money);

        // then
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("입력한 금액이 유효하지 않는 경우 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {5300, 3100})
    void purchaseLottosWithInvalidValue(final int value) {
        // given
        LottoService lottoService  = LottoService.init(new TestLottoGenerator());
        Money money = Money.valueOf(value);

        // when, then
        assertThatThrownBy(() -> lottoService.purchaseLotto(money))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 보너스 번호를 통해 당첨 번호를 생성할 수 있다.")
    @Test
    void createWinningLottoByLottoNumbersAnsBonusNumber() {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        WinningLotto winningLotto = lottoService.createWinningLotto(lottoNumbers, bonusNumber);

        // then
        assertThat(winningLotto).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("당첨 번호 생성 시 유효하지 않은 값이 들어오면 예외가 발생한다.")
    @ParameterizedTest(name = "[{index}] : lottoNumbers = {0}, bonusNumber = {1}")
    @MethodSource("winningLottoArgument")
    void createWinningLottoByInvalidInput(final List<Integer> lottoNumbers,
                                          final int bonusNUmber) {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());

        // when, then
        assertThatThrownBy(() -> lottoService.createWinningLotto(lottoNumbers, bonusNUmber))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> winningLottoArgument() {
        return Stream.of(
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 50),
                10
            ),
            Arguments.of(
                List.of(1, 1, 3, 4, 5, 6),
                10
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6, 7),
                10
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                50
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                1
            )
        );
    }

    @DisplayName("구매한 모든 로또들의 통계를 판단할 수 있다.")
    @ParameterizedTest
    @MethodSource("lottoJudgeArgument")
    void judgeAllBuyingLottos(final List<Integer> winningLottoNumbers,
        final int bonusNumber,
        final LottoRanking expected) {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());

        Money money = Money.valueOf(1000);
        List<Lotto> buyingLottos = lottoService.purchaseLotto(money);

        WinningLotto winningLotto
            = lottoService.createWinningLotto(winningLottoNumbers, bonusNumber);

        // when
        Statistic statistic = lottoService.judgeAll(winningLotto, buyingLottos);

        // then
        assertThat(statistic.getCount(expected)).isEqualTo(1);
    }

    static Stream<Arguments> lottoJudgeArgument() {
        return Stream.of(
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 6),
                10,
                LottoRanking.FIRST
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 16),
                6,
                LottoRanking.SECOND
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 5, 16),
                10,
                LottoRanking.THIRD
            ),
            Arguments.of(
                List.of(1, 2, 3, 4, 15, 16),
                10,
                LottoRanking.FOURTH
            ),
            Arguments.of(
                List.of(1, 2, 3, 14, 15, 16),
                10,
                LottoRanking.FIFTH
            ),
            Arguments.of(
                List.of(1, 2, 13, 14, 15, 16),
                10,
                LottoRanking.UNRANKED
            )
        );
    }

    @DisplayName("수익률을 계산할 수 있다.")
    @Test
    void calCalculateEarningRate() {
        // given
        LottoService lottoService = LottoService.init(new TestLottoGenerator());

        Money money = Money.valueOf(1000);
        List<Lotto> buyingLottos = lottoService.purchaseLotto(money);

        List<Integer> winningLottoNumbers = List.of(1, 2, 3, 14, 15, 16);
        int bonusNumber = 10;
        WinningLotto winningLotto
            = lottoService.createWinningLotto(winningLottoNumbers, bonusNumber);

        Statistic statistic = lottoService.judgeAll(winningLotto, buyingLottos);

        // when
        double earningRate = lottoService.calculateEarningRate(statistic);

        // then
        assertThat(earningRate).isEqualTo(500.0);
    }

}
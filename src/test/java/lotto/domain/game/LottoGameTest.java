package lotto.domain.game;

import lotto.constants.ErrorConsts;
import lotto.constants.LottoConsts;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.WinningNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;


class LottoGameTest {
    private LottoNumberGenerator numberGenerator;
    private WinningNumber winningNumber;
    private Money money;

    @BeforeEach
    void setUp() {
        numberGenerator = Mockito.mock(LottoNumberGenerator.class);
        final Set<LottoNumber> winningNumbers = IntStream.rangeClosed(1, 6)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toSet());
        winningNumber = new WinningNumber(new LottoNumbers(winningNumbers), new LottoNumber(7));

        money = new Money(5000);

        when(numberGenerator.generateLottoNumbers())
                .thenReturn(new LottoNumbers(winningNumbers));
    }

    @Test
    void 로또_게임_생성_및_상금_계산() {
        // given
        final LottoGame lottoGame = LottoGame.of(money, numberGenerator);
        lottoGame.updateWinningNumber(winningNumber);

        // when
        final Prizes prizes = lottoGame.calculatePrizes();

        // then
        assertThat(prizes.prizes())
                .hasSize(5)
                .containsOnly(Prize.FIRST);

        final BigDecimal profit = lottoGame.calculateProfitRate(prizes);
        assertThat(profit).isEqualByComparingTo("200000000.00"); // 기대하는 수익률 값과 비교
    }

    @Test
    void 유효한_금액으로_로또_개수_계산() {
        // given
        final int validPrice = LottoConsts.LOTTO_PRICE.getValue() * 5; // 로또 가격의 배수로 유효한 금액 설정

        // when
        final Money money = new Money(validPrice);

        // then
        assertThat(money.countLotto()).isEqualTo(5);
    }

    @Test
    void 로또_가격으로_나누어떨어지지_않는_금액_예외_발생() {
        // given
        final int invalidPrice = LottoConsts.LOTTO_PRICE.getValue() + 1; // 로또 가격으로 나누어 떨어지지 않는 금액 설정

        // when & then
        assertThatThrownBy(() -> new Money(invalidPrice))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorConsts.MONEY_NOT_DIVIDED_BY_LOTTO_PRICE.getMessage());
    }
}

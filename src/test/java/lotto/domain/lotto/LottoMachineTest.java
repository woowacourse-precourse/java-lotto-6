package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Money;
import lotto.global.constant.message.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {

    @ParameterizedTest
    @MethodSource("validMoneyUnitParameters")
    void 금액이_지정된_단위로_입력되면_로또_생성(int lottoPrice, int amount, int expectedValue) {
        Money money = new Money(amount);
        LottoMachine lottoMachine = new LottoMachine(lottoPrice);

        List<Lotto> lottos = lottoMachine.purchaseLottos(money);

        int actualValue = lottos.size();
        Assertions.assertEquals(actualValue, expectedValue);
    }

    static Stream<Arguments> validMoneyUnitParameters() {
        return Stream.of(
                Arguments.of(1_000, 1_000, 1),
                Arguments.of(3_000, 3_000, 1),
                Arguments.of(15_000, 30_000, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidMoneyUnitParameters")
    void 금액이_지정된_단위로_나누어_떨어지지_않으면_예외_발생(int lottoPrice, int amount) {
        LottoMachine lottoMachine = new LottoMachine(lottoPrice);
        Money money = new Money(amount);

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> lottoMachine.purchaseLottos(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.MONEY_UNIT_ERROR.getText());
    }

    static Stream<Arguments> invalidMoneyUnitParameters() {
        return Stream.of(
                Arguments.of(1_000, 1_200),
                Arguments.of(3_000, 3_500),
                Arguments.of(15_000, 15_700)
        );
    }
}

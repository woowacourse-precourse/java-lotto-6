package lotto.domain.lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.money.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoMachineTest {

    @ParameterizedTest
    @MethodSource("validMoneyParameters")
    void 입력받은_금액만큼_로또_생성(int amount, int expectedValue) {
        Money money = new Money(amount);
        LottoMachine lottoMachine = new LottoMachine();

        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        int actualValue = lottos.size();
        Assertions.assertEquals(actualValue, expectedValue);
    }

    static Stream<Arguments> validMoneyParameters() {
        return Stream.of(
                Arguments.of(1_000, 1),
                Arguments.of(3_000, 3),
                Arguments.of(15_000, 15)
        );
    }
}

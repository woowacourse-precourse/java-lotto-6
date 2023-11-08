package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoDispenserTest {

    @DisplayName("돈을 로또 디스펜서에 넣으면, 구입할 수 있는 만큼 로또가 발행된다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 2000, 3000})
    void issueLottos(long input) {
        Money money = new Money(input);
        Lottos lottos = LottoDispenser.issueLottos(money);

        long actualNumberOfIssuedLotto = lottos.getLottos().size();
        long expectedNumberOfIssuedLotto = input / 1000;

        assertEquals(expectedNumberOfIssuedLotto, actualNumberOfIssuedLotto);
    }
}
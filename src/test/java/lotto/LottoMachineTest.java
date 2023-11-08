package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoMachineTest {

    @DisplayName("(INPUT_MONEY % 1000)개의 로또를 발급한다.")
    @Test
    void issueLottos() {
        String money = "5000";
        List<Lotto> lottos = LottoMachine.issueLotto(money);
        Assertions.assertEquals(5, lottos.size());
    }

    @DisplayName("숫자로 구성되어 있지 않다면 예외를 던진다.")
    @Test
    void issueLottosWithWrongMoneyInput() {
        String money = "5k";
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoMachine.issueLotto(money));
    }

    @DisplayName("1,000 단위가 아니라면 예외를 던진다. ")
    @Test
    void issueLottosWithSmallerUnit() {
        String money = "1500";
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoMachine.issueLotto(money));
    }

}
package lotto.domain.controller;

import lotto.domain.controller.LottoController;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotto;
import lotto.domain.model.Money;
import lotto.io.FakeLottoInput;
import lotto.io.FakeLottoOutput;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private final LottoController controller;

    public LottoControllerTest() {
        this.controller = new LottoController(new FakeLottoInput(), new FakeLottoOutput());
    }

    @Test
    void 구입_금액_입력_테스트() {
        Money money = controller.receiveMoney();

        assertEquals(new Money(1000), money);
    }

    @Test
    void 당첨_번호_입력_테스트() {
        Lotto lotto = controller.receiveWinningNumber();

        assertEquals(new Lotto(List.of(1, 2, 3, 4, 5, 6)), lotto);
    }

    @Test
    void 보너스_번호_입력_테스트() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = controller.receiveBonusNumber(lotto);

        assertEquals(new BonusNumber(7, lotto), bonusNumber);
    }
}
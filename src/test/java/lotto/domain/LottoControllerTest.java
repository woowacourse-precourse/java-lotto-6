package lotto.domain;

import lotto.io.FakeLottoInput;
import lotto.io.FakeLottoOutput;
import org.junit.jupiter.api.Test;

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
}
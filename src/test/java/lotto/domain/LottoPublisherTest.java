package lotto.domain;

import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPublisherTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1500", "-1000"})
    void 구입_금액이_올바르지_않을_경우(String money) {
        assertThatThrownBy(() -> new LottoPublisher(money))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2000", "100000"})
    void 발행한_로또_갯수_확인(String money) {
        LottoPublisher lottoPublisher = new LottoPublisher(money);

        int expectedLottoAmount = Integer.parseInt(money) / PURCHASE_UNIT.getNumber();
        int actualLottoAmount = lottoPublisher.getLottoAmount();

        assertEquals(expectedLottoAmount, actualLottoAmount);
    }
}

package lotto.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CasherTest {
    Casher casher = null;

    @BeforeEach
    void before() {
        casher = new Casher();
    }

    @Test
    void 로또_발행개수_금액부족_예외테스트() {
        int price = 900;

        Assertions.assertThatThrownBy(() -> casher.getLottoCount(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액이 부족합니다. 최소금액 : " + 1000);
    }

    @Test
    void 로또_발행개수_나머지발생_예외테스트() {
        int price = 1300;

        Assertions.assertThatThrownBy(() -> casher.getLottoCount(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 금액 단위로 입력해야 합니다. 입력단위 : " + 1000);
    }

}

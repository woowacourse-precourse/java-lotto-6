package lotto.collaboration.lottos;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class LottosTest {

    @Test
    void 천원단위_금액으로_정상지불함() {
        assertThatNoException()
                .isThrownBy(() ->
                        new Lottos().purchase(1000));
    }

    @Test
    void 천원단위가_아닌금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new Lottos().purchase(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매범위를_하회하는금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new Lottos().purchase(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매범위를_상회하는금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new Lottos().purchase(100001))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
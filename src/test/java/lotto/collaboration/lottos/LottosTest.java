package lotto.collaboration.lottos;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.io.lottos.SuccessLottosRandoms;
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

    @Test
    void 정상지불후_로또를만들면_로또번호가반환됨() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        Lottos lottos = new Lottos();
        lottos.purchase(1000);
        List<Lotto> actual = lottos.make(new SuccessLottosRandoms());

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0).toString()).isEqualTo(expected.toString());
    }

}
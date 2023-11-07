package lotto.collaboration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.collaboration.dto.PlayerLotto;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

    @Test
    void 천원단위_금액으로_정상지불함() {
        assertThatNoException()
                .isThrownBy(() ->
                        new LottoStore().purchase(1000));
    }

    @Test
    void 천원단위가_아닌금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new LottoStore().purchase(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매범위를_하회하는금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new LottoStore().purchase(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매범위를_상회하는금액으로_비정상지불하면예외() {
        assertThatThrownBy(() ->
                new LottoStore().purchase(100001))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상지불후_로또를만들면_로또번호가반환됨() {
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6);

        LottoStore lottoStore = new LottoStore();
        lottoStore.purchase(1000);
        List<PlayerLotto> actual = lottoStore.make(() -> List.of(1, 2, 3, 4, 5, 6));

        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual.get(0).toString()).isEqualTo(expected.toString());
    }

}
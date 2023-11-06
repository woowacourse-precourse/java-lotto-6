package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(ReplaceUnderscores.class)
@SuppressWarnings("NonAsciiCharacters")
class LottosTest {

    @Test
    void 구매한_수만큼_로또가_생성된다() {
        // given
        long buyCount = 10;
        Lottos lottos = Lottos.of(buyCount, new RandomNumberGenerator());

        // when
        List<Lotto> purchasedLottos = lottos.getPurchasedLottos();

        // then
        assertThat(purchasedLottos).hasSize((int) buyCount);
    }
}

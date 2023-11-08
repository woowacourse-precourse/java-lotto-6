package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoManagerTest {

    final LottoManager lottoManager = new LottoManager();

    @Test
    void 구매금액에_맞는_구매_개수만큼_로또를_발행한다() {
        //given
        final User user1 = new User(1000);
        final User user2 = new User(100_000);

        //when
        lottoManager.purchaseLotto(user1);
        lottoManager.purchaseLotto(user2);

        //then
        assertThat(user1.getPurchasedLotto().size()).isEqualTo(1);
        assertThat(user2.getPurchasedLotto().size()).isEqualTo(100);
    }
}

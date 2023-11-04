package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @DisplayName("발급 가능한 로또의 수 만큼 로또 객체를 생성한다.")
    @Test
    void createLottosTest() {
        // given
        int input = 3000;
        Money money = Money.of(input);
        LottoGenerator lottoGenerator = new LottoGenerator(new RandomNumberGenerator());

        // when
        Lottos lottos = lottoGenerator.generateLotto(money);

        // then
        Assertions.assertThat(lottos.getLottoCount())
                .isEqualTo(money.calculateNumberOfLotto());
    }
}

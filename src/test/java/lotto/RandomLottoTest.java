package lotto;

import lotto.Model.Price;
import lotto.Model.RandomLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomLottoTest {

    @DisplayName("로또 구입 금액에 따라 발행될 로또 개수 테스트")
    @Test
    void createRandomLottoCounting() {
        RandomLotto randomLotto = new RandomLotto(new Price("5000"));

        Assertions.assertThat(randomLotto.getCount()).isEqualTo(5);
    }
}

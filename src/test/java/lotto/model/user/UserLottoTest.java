package lotto.model.user;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.user.UserLotto;
import lotto.util.generator.NumberGenerator;
import lotto.util.generator.RandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserLottoTest {
    NumberGenerator numberGenerator;

    @BeforeEach
    void setUp() {
        numberGenerator = new RandomNumberGenerator();
    }

    @Test
    void 임의의_로또를_amount개_발행한다() {
        int amount = 5;
        UserLotto userLotto = new UserLotto(amount, numberGenerator);
        assertThat(userLotto.getLottos().size()).isEqualTo(amount);
    }
}
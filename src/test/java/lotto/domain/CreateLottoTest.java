package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CreateLottoTest {
    private CreateLotto createLotto;

    @BeforeEach
    void setUp() {
        createLotto = new CreateLotto();
    }

    @DisplayName("주어진 갯수만큼의 로또로 이루어진 리스트를 생성한다.")
    @Test
    void createMultipleLotto() {
        Money money = new Money("5000");

        createLotto.setAmount(money);
        createLotto.multipleLotto();

        assertThat(createLotto.getLottos()).hasSize(5);
        assertThat(createLotto.getLottos()).allMatch(lotto -> lotto instanceof Lotto);
    }
}
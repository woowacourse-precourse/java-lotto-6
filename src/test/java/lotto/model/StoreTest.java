package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StoreTest {

    @Test
    @DisplayName("주어진 금액으로 올바른 로또 갯수를 사는지 테스트")
    void countLottoTest() {
        int money = 5000;
        int expectedCount = 5;

        int actualCount = Store.countLotto(money);

        assertThat(actualCount).isEqualTo(expectedCount);
    }
}
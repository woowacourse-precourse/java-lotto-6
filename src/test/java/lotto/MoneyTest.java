package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 숫자_유무_확인() {
        assertThatThrownBy(() -> new Money("a10305"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 앞자리_숫자_0_확인() {
        assertThatThrownBy(() -> new Money("01000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 천원_단위_확인() {
        assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 값_출력() {
        assertThat(new Money("15000").currentMoney())
                .isEqualTo(15000);
    }
}
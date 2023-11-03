package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

public class LottoNoTest {

    @Test
    void 로또_번호_범위_테스트() {
        assertAll(
                () -> assertThatThrownBy(() -> new LottoNo(0))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new LottoNo(46))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

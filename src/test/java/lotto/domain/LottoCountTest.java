package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoCountTest {
    @DisplayName("from은 구입 금액을 통해 로또 수량 객체를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "2000, 2", "101000, 101"})
    void check_from(int purchase, int count) {
        LottoCount lottoCount = LottoCount.from(purchase);
        assertThat(lottoCount.getCount()).isEqualTo(count);
    }
}

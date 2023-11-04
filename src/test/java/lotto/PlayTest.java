package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.controller.Play.calLottoCount;

public class PlayTest {
    @DisplayName("로또 한 장의 금액에 따라서 로또의 수를 반환한다.")
    @Test
    void calLottoCountTest() {
        int priceA = 10000;
        int lottoCountA = calLottoCount(priceA);
        Assertions.assertThat(lottoCountA).isEqualTo(10);

        int priceB = 10010;
        int lottoCountB = calLottoCount(priceB);
        Assertions.assertThat(lottoCountB).isEqualTo(10);

    }
}

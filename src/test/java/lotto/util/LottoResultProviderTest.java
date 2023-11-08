package lotto.util;

import lotto.domain.lottoresult.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultProviderTest {

    @Test
    void test() {
        Assertions.assertThat(LottoResultProvider.getLottoResult()).isEqualTo(LottoResult.FIFTH);
        Assertions.assertThat(LottoResultProvider.getLottoResult()).isEqualTo(LottoResult.FOURTH);
        Assertions.assertThat(LottoResultProvider.getLottoResult()).isEqualTo(LottoResult.THIRD);
        Assertions.assertThat(LottoResultProvider.getLottoResult()).isEqualTo(LottoResult.SECOND);
        Assertions.assertThat(LottoResultProvider.getLottoResult()).isEqualTo(LottoResult.FIRST);
    }

}
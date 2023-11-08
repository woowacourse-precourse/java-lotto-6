package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void compareLottoNumberTest() {
        LottoResult lottoResult = new LottoResult();

        int result = lottoResult.compareLottoNumber(List.of(1,2,3,4,5,6,7),List.of(1,2,3,7,8,9));
        assertThat(result).isEqualTo(3);
    }

    @Test
    void compareBonusNumberTest() {
        LottoResult lottoResult = new LottoResult();

        boolean result = lottoResult.compareBonusNumber(List.of(1,2,3,4,5,6,7),List.of(1,2,5,6,7,8));
        assertThat(result).isEqualTo(true);
    }

    @Test
    void compareBonusNumberTest2() {
        LottoResult lottoResult = new LottoResult();

        boolean result = lottoResult.compareBonusNumber(List.of(1,2,3,4,5,6,7),List.of(1,2,4,5,6,8));
        assertThat(result).isEqualTo(false);
    }

}
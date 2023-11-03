package lotto.domain.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @Test
    void lottoResultTest_1() {
        LottoResult result_First = LottoResult.getResult(6, false);
        LottoResult result_Second = LottoResult.getResult(5, true);
        LottoResult result_Third = LottoResult.getResult(5, false);
        LottoResult result_Fourth_1 = LottoResult.getResult(4, true);
        LottoResult result_Fourth_2 = LottoResult.getResult(4, false);
        LottoResult result_Fifth_1 = LottoResult.getResult(3, true);
        LottoResult result_Fifth_2 = LottoResult.getResult(3, false);

        Assertions.assertThat(result_First).isEqualTo(LottoResult.FIRST);
        Assertions.assertThat(result_Second).isEqualTo(LottoResult.SECOND);
        Assertions.assertThat(result_Third).isEqualTo(LottoResult.THIRD);
        Assertions.assertThat(result_Fourth_1).isEqualTo(LottoResult.FOURTH);
        Assertions.assertThat(result_Fourth_2).isEqualTo(LottoResult.FOURTH);
        Assertions.assertThat(result_Fifth_1).isEqualTo(LottoResult.FIFTH);
        Assertions.assertThat(result_Fifth_2).isEqualTo(LottoResult.FIFTH);
    }

}
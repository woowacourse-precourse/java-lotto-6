package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.lottoresult.LottoResult;
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

        assertThat(result_First).isEqualTo(LottoResult.FIRST);
        assertThat(result_Second).isEqualTo(LottoResult.SECOND);
        assertThat(result_Third).isEqualTo(LottoResult.THIRD);
        assertThat(result_Fourth_1).isEqualTo(LottoResult.FOURTH);
        assertThat(result_Fourth_2).isEqualTo(LottoResult.FOURTH);
        assertThat(result_Fifth_1).isEqualTo(LottoResult.FIFTH);
        assertThat(result_Fifth_2).isEqualTo(LottoResult.FIFTH);
    }

}
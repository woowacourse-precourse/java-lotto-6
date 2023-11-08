package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import lotto.generator.LottoResultGenerator;
import lotto.option.EqualStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    @DisplayName("서로 다른 LottoResult의 GameStatus가 같으면 같은 객체로 간주한다.")
    @Test
    void checkLottoResultEqual() {
        //given
        //when
        LottoResult lottoResult = new LottoResult(EqualStatus.SIX_EQUAL);
        LottoResult lottoResult1 = new LottoResult(EqualStatus.SIX_EQUAL);
        LottoResult lottoResult2 = LottoResultGenerator.setEqualStatus(6, 0);
        //then
        assertSoftly(softAssertions -> {
            assertThat(lottoResult).isEqualTo(lottoResult1);
            assertThat(lottoResult).isEqualTo(lottoResult2);
        });
    }
}

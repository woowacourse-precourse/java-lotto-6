package lotto.Model;

import static lotto.Global.LottoResult.FIRST_RESULT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LottoResultGeneratorTest {
    static LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();

    @Order(1)
    @Test
    void 당첨_로또_생성_검증() {
        lottoResultGenerator.putWinningLottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 9);
    }

    @Order(2)
    @Test
    void 로또_구입_검증() {
        lottoResultGenerator.getSelledLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Order(3)
    @Test
    void 로또_결과_검증() {
        assertThat(lottoResultGenerator.getLottosResult().get(FIRST_RESULT.getName()) == 1);
    }

    @Order(4)
    @Test
    void 로또_수익률_검증() {
        assertThat(lottoResultGenerator.getLottoRateOfResult(lottoResultGenerator.getLottosResult())
                == 2000000000 / 1000 * 100);
    }

}
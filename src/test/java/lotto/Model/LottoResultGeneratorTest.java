package lotto.Model;

import static lotto.Global.LottoResult.FIRST_RESULT;
import static lotto.Global.LottoResult.SECOND_RESULT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.List;
import lotto.Global.LottoResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LottoResultGeneratorTest {
    static LottoResultGenerator lottoResultGenerator = new LottoResultGenerator();

    @DisplayName("당첨 로또를 생성하는 과정을 검증")
    @Order(1)
    @Test
    void winningLottoValidate() {
        lottoResultGenerator.putWinningLottoNumber(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 9);
        lottoResultGenerator.getLottosResult().values().stream().forEach(number -> assertThat(number.intValue() == 0));
    }


    @DisplayName("로또를 구입하는 과정을 검증")
    @Order(2)
    @Test
    void buyLotto() {
        lottoResultGenerator.getSelledLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottoResultGenerator.getSelledLotto(new Lotto(List.of(1, 2, 3, 4, 5, 9)));
        HashMap<String, Integer> result = lottoResultGenerator.getLottosResult();
        assertThat(result.get(FIRST_RESULT.name()) == 1);
        assertThat(result.get(SECOND_RESULT.name()) == 1);
        result.values().stream().toList().subList(0, result.size() - 2).forEach(number -> assertThat(number == 0));
    }

    @DisplayName("로또 결과 객체 형식을 검증")
    @Order(3)
    @Test
    void lottoMatchResult() {
        lottoResultGenerator.getLottosResult().keySet().containsAll(List.of(LottoResult.values()));
    }

    @DisplayName("로또 수익 결과 검증")
    @Order(4)
    @Test
    void lottoRateOfResult() {
        assertThat(lottoResultGenerator.getLottoRateOfResult(lottoResultGenerator.getLottosResult())
                == (2000000000 + 30000000) / 2000 * 100);
    }

}
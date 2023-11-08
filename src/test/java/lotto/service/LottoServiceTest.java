package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import lotto.model.Bonus;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @DisplayName("로또 발행 테스팅")
    @Test
    void 로또_3개_발행_테스팅() {
        int purchasePrice = 3000;
        int lottoPrice = 1000;
        int expectedResult = 3;
        List<Lotto> lottos = lottoService.publishLottos(purchasePrice);
        assertEquals(expectedResult, lottos.size());
    }

    @DisplayName("자신의 로또와 당첨 번호 비교 테스팅")
    @Test
    void 당첨번호_비교_테스팅() {
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
        Lotto winnerLotto = new Lotto(List.of(1,2,3,4,5,6));
        int expectedResult = 6;
        assertEquals(expectedResult, lottoService.getMatchCount(myLotto, winnerLotto));
    }

    @DisplayName("자신의 로또와 보너스 번호 비교 테스팅")
    @Test
    void 보너스번호_비교_테스팅() {
        Lotto myLotto = new Lotto(List.of(1,2,3,4,5,6));
        Bonus bonusNumber = new Bonus(1);
        boolean expectedResult = true;
        assertEquals(expectedResult, lottoService.getIsMatchBonus(myLotto, bonusNumber));
    }
}

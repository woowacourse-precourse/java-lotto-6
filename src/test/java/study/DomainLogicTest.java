package study;

import java.util.List;
import java.util.Map;
import lotto.config.Constants;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyer;
import lotto.domain.Rank;
import lotto.service.Calculator;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoShop;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.RepeatedTest;

public class DomainLogicTest {

    Lotto target = new Lotto(List.of(1,3,5,7,9,11));
    int bonus = 13;
    LottoShop lottoShop = new LottoShop(new LottoNumberGenerator());
    List<Lotto> lottos = lottoShop.sell(100);

    @RepeatedTest(100)
    void 도메인로직_교차검증(){
        LottoBuyer buyer = new LottoBuyer(lottos);
        Map<Rank, Integer> result = buyer.checkAllLotto(target, bonus);
        double rate = Calculator.calculateRateOfReturn(result, buyer.payment());

        Assertions.assertThat(rate).isCloseTo(testLogic(), Offset.offset(0.000001));  // 부동 소수점
    }

    private double testLogic(){
        double sum = lottos.stream()
                .map(lotto -> lotto.match(target, bonus))
                .mapToLong(rank -> rank.reward)
                .sum();
        return sum * 100 / (Constants.LOTTO_PRICE * lottos.size());
    }
}

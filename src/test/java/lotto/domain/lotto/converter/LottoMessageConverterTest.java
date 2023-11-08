package lotto.domain.lotto.converter;

import java.util.List;
import lotto.domain.GameResult;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMessageConverterTest {

    @Test
    void 구매한_로또_번호_메시지_컨버팅() {
        List<Lotto> lottos = List.of(new Lotto(List.of(11, 24, 43, 26, 16, 7)), new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        String actualValue = LottoMessageConverter.convertLottoNumberMessage(lottos);
        String expectedValue = """
                                
                2개를 구매했습니다.
                [11, 24, 43, 26, 16, 7]
                [1, 2, 3, 4, 5, 6]
                """;

        Assertions.assertEquals(actualValue, expectedValue);
    }

    @Test
    void 로또_결과_메시지_컨버팅() {
        Money money = new Money(8000);
        GameResult result = GameResult.createInitialResult();
        result.add(Rank.FIFTH);

        double profitPercentage = result.calculateProfitPercentage(money);

        String actualValue = LottoMessageConverter.convertLottoResultMessage(result, profitPercentage);
        String expectedValue = """
                                
                당첨 통계
                ---
                3개 일치 (5,000원) - 1개
                4개 일치 (50,000원) - 0개
                5개 일치 (1,500,000원) - 0개
                5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
                6개 일치 (2,000,000,000원) - 0개
                총 수익률은 62.5%입니다.""";

        Assertions.assertEquals(actualValue, expectedValue);
    }
}

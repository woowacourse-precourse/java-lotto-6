package lotto.domain;

import static lotto.domain.LottoRank.FIFTH;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.NOTHING;
import static lotto.domain.LottoRank.SECOND;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("LottoResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoResultTest {

    @Test
    void create_정적_팩토리_메소드는_당첨등수를_갖는_자료구조를_초기화한다() {
        LottoResult lottoResult = LottoResult.create();

        Assertions.assertTrue(isEquals(lottoResult.getResult()));
    }

    private boolean isEquals(Map<LottoRank, Integer> result) {
        return Arrays.stream(LottoRank.values())
                .filter(LottoRank::isNotNothing)
                .allMatch(result::containsKey);
    }

    @ParameterizedTest
    @MethodSource("provideLottoRanks")
    void addLottoRankCount_메소드는_당첨등수_개수를_계산해_자료구조를_업데이트한다(List<LottoRank> ranks, LottoRank rank, int expect) {
        LottoResult lottoResult = LottoResult.create();
        lottoResult.addLottoRankCount(ranks);

        Assertions.assertEquals(lottoResult.getResult().get(rank), expect);
    }

    private static Stream<Arguments> provideLottoRanks() {
        return Stream.of(
                Arguments.of(List.of(NOTHING, FIRST, FIFTH, FIFTH), FIFTH, 2),
                Arguments.of(List.of(NOTHING, NOTHING, SECOND), SECOND, 1)
        );
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:6000", "5000:1200", "10000:600"}, delimiter = ':')
    void calculateTotalReturn_메소드는_구매금액이_주어지면_수익률을_반환한다(int money, double totalReturn) {
        Money testMoney = new Money(money);
        LottoResult lottoResult = LottoResult.create();
        lottoResult.addLottoRankCount(List.of(FIFTH, FIFTH, FOURTH));

        Assertions.assertEquals(lottoResult.calculateTotalReturn(testMoney), totalReturn);
    }
}

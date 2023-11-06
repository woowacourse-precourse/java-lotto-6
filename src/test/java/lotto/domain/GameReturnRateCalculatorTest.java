package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("수익률 확인")
class GameReturnRateCalculatorTest {

    @DisplayName("수익률 정상 리턴")
    @Test
    void getReturnRate() {
        // given

        // 로또를 10개 샀다.
        // 로또는 하나에 1000원이다.
        // 로또 사는데 10,000원을 썼다.
        BigDecimal givenBuyPrice = BigDecimal.valueOf(10 * 1000);

        // 1등 1개, 2등 2개, 5등 2개, 꽝 5개가 나왔다.
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 1,
                Rank.RANK_2, 2,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 2,
                Rank.UNRANK, 5
        );

        // 1등 : 2,000,000,000 원 이 1개 = 2,000,000,000
        // 2등 : 30,000,000 원 이 2개 = 60,000,000
        // 5등 : 5,000 원 이 2개 = 10,000
        // 총합 : 2,060,010,000

        // 수익률 계산 : 총합 / 구매금액 * 100(%)
        // 2,060,010,000 / 10,000 * 100 = 20,600,100
        BigDecimal expectedResult = BigDecimal.valueOf(20600100).setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("아주 큰 수익률 정상 리턴")
    @Test
    void getVeryLargeReturnRate() {
        // given

        // 로또를 100개 샀다.
        // 로또는 하나에 1000원이다.
        // 로또 사는데 100,000원을 썼다.
        BigDecimal givenBuyPrice = BigDecimal.valueOf(100 * 1000);

        // 1등 99개, 2등 1개
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 99,
                Rank.RANK_2, 1,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 0,
                Rank.UNRANK, 0
        );

        // 1등 : 2,000,000,000 원 이 99개 = 198,000,000,000
        // 2등 : 30,000,000 원 이 1개 = 30,000,000
        // 총합 : 198,030,000,000

        // 수익률 계산 : 총합 / 구매금액 * 100(%)
        // 198,030,000,000 / 100,000 * 100 = 180,030,000
        BigDecimal expectedResult = BigDecimal.valueOf(198030000).setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("더 아주 큰 수익률 정상 리턴")
    @Test
    void getMoreVeryLargeReturnRate() {
        // given

        // 로또를 10000개 샀다.
        // 로또는 하나에 1000원이다.
        // 로또 사는데 10,000,000원을 썼다.
        BigDecimal givenBuyPrice = BigDecimal.valueOf(10000 * 1000);

        // 1등 10000개
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 10000,
                Rank.RANK_2, 0,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 0,
                Rank.UNRANK, 0
        );

        // 1등 : 2,000,000,000 원 이 10000개 = 20000000000000
        // 총합 : 20000000000000

        // 수익률 계산 : 총합 / 구매금액 * 100(%)
        // 20000000000000 / 10000000 * 100 = 200000000
        BigDecimal expectedResult = BigDecimal.valueOf(200000000).setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("수익률 아주 작은 수익률 정상 리턴")
    @Test
    void getVerySmallReturnRate() {
        // given

        // 로또를 100000개 샀다.
        // 로또는 하나에 1000원이다.
        // 로또 사는데 100000000원을 썼다.
        BigDecimal givenBuyPrice = BigDecimal.valueOf(100000 * 1000);

        // 5등 1개
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 0,
                Rank.RANK_2, 0,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 1,
                Rank.UNRANK, 99999
        );

        // 5등 : 5,000 원 이 1개 = 5,000
        // 총합 : 5,000

        // 수익률 계산 : 총합 / 구매금액 * 100(%)
        // 5,000 / 100000000 * 100 = 0.005
        // 소숫점 2자리에서 반올림하여 0.01 예상!
        BigDecimal expectedResult = BigDecimal.valueOf(0.01).setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }

    @DisplayName("수익률 작은 수익률 정상 리턴")
    @Test
    void getSmallReturnRate() {
        // given

        // 로또를 100개 샀다.
        // 로또는 하나에 1000원이다.
        // 로또 사는데 100,000 썼다.
        BigDecimal givenBuyPrice = BigDecimal.valueOf(100 * 1000);

        // 5등 1개
        Map<Rank, Integer> givenGameResult = Map.of(
                Rank.RANK_1, 0,
                Rank.RANK_2, 0,
                Rank.RANK_3, 0,
                Rank.RANK_4, 0,
                Rank.RANK_5, 1,
                Rank.UNRANK, 99
        );

        // 5등 : 5,000 원 이 1개 = 5,000
        // 총합 : 5,000

        // 수익률 계산 : 총합 / 구매금액 * 100(%)
        // 5,000 / 100,000 * 100 = 5%
        BigDecimal expectedResult = BigDecimal.valueOf(5).setScale(1, RoundingMode.HALF_UP);

        // when
        BigDecimal realResult = GameReturnRateCalculator.getReturnRate(givenGameResult, givenBuyPrice);

        // then
        assertThat(realResult).isEqualTo(expectedResult);
    }
}

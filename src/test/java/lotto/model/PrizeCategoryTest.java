package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PrizeCategoryTest {

    @DisplayName("결과지의 기본 상금 확인")
    @ParameterizedTest(name = "{0}등 기본 상금은 {1}이다.")
    @CsvSource(value = {"5:5000","4:50000","3:1500000","2:30000000","1:2000000000"}, delimiter = ':')
    public void getBasicPrize(int rank, int expectedBasicPrize) {
        PrizeCategory[] results = PrizeCategory.values();
        PrizeCategory prizeCategory = results[Math.abs(rank-5)]; // 배열 인덱스의 첫 번쨰는 5등부터 시작하므로 절대값을 취한다.

        assertEquals(expectedBasicPrize, prizeCategory.getBasicPrize());
    }
}
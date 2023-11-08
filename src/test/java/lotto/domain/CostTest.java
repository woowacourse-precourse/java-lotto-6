package lotto.domain;

import static lotto.constants.Constants.LOTTO_COST;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CostTest {

    @ParameterizedTest
    @DisplayName("구입 가능 횟수 기능 테스트")
    @CsvSource({"1000", "100000", "100000"})
    void costGetterTest(int costNumber) {
        Cost cost = new Cost(costNumber);
        Assertions.assertThat(cost.getDivideCost()).isEqualTo(costNumber / LOTTO_COST);
    }

    @ParameterizedTest
    @DisplayName("금액 반복 기능 테스트")
    @CsvSource({"1000", "100000", "100000"})
    void costIterateTest(int costNumber) {
        //given
        int count = 0;
        Cost cost = new Cost(costNumber);
        //when
        while (cost.hasMoney()) {
            count++;
            cost.buyingLotto();
        }
        //then
        Assertions.assertThat(count).isEqualTo(costNumber / LOTTO_COST);
    }

}
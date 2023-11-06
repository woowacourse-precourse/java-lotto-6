package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LotteriesGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("구입 갯수가 양수가 아니라면 예외 발생")
    void createByPurchaseCountNotPositiveExceptionTest(final int purchaseCount) {
        // given
        NumbersGeneratorStrategy numbersGeneratorStrategy = () -> List.of(1, 2, 3, 4, 5, 6);
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);

        // expected
        assertThrows(IllegalArgumentException.class, () -> lotteriesGenerator.createByPurchaseCount(purchaseCount));
    }

    @Test
    @DisplayName("구입 갯수만큼 로또를 생성하는 테스트")
    void createByPurchaseCountTest() {
        // given
        int purchaseCount = 5;
        NumbersGeneratorStrategy numbersGeneratorStrategy = () -> List.of(1, 2, 3, 4, 5, 6);
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);

        // when
        Lotteries lotteries = lotteriesGenerator.createByPurchaseCount(purchaseCount);

        // then
        assertEquals(5, lotteries.getLotteries().size());
    }
}
package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteriesGeneratorTest {

    @Test
    @DisplayName("구입 갯수만큼 로또를 생성하는 테스트")
    void createByPurchaseCountTest() {
        // given
        Money money = Money.from(5000);
        NumbersGeneratorStrategy numbersGeneratorStrategy = () -> List.of(1, 2, 3, 4, 5, 6);
        LotteriesGenerator lotteriesGenerator = new LotteriesGenerator(numbersGeneratorStrategy);

        // when
        Lotteries lotteries = lotteriesGenerator.createByPurchaseCount(money);

        // then
        assertEquals(5, lotteries.getLotteries().size());
    }
}
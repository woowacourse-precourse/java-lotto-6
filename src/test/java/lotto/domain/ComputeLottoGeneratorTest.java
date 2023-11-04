package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputeLottoGeneratorTest {

    @Test
    @DisplayName("구매한 로또 수 만큼 로또를 생성한다.")
    void createComputeLottoGeneratorTest() {
        new ComputeLottoGenerator(new Quantity(new Price(8000))).generatorLottoList()
                .forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
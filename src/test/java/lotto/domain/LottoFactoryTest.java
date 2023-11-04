package lotto.domain;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoFactoryTest {


    @ParameterizedTest(name = "입력받은 값을 , 으로 쪼개서 List<Integer> 로 반환")
    @ValueSource(strings = "1,24,34,45,6,5")
    void parseStringToLottoNumberTest(final String argument) {
        Assertions.assertEquals(LottoFactory.createLottoFrom(argument).getNumbers(),
                new Lotto(List.of(1, 24, 34, 45, 6, 5)).getNumbers());
    }
}

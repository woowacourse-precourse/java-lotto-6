package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberGeneratorTest {

    @DisplayName("발행할 수만큼 랜덤 로또 번호를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 7})
    void generateRandomNumbers(int number) {
        List<List<Integer>> randomNumbers = LottoNumberGenerator.generateRandomNumbers(number);
        assertEquals(number, randomNumbers.size());
    }
}
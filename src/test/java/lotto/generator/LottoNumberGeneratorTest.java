package lotto.generator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {

    @DisplayName("6개의 숫자가 생성되는지 테스트")
    @Test
    void generateTest() {
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
        List<Integer> result = lottoNumbersGenerator.generate();
        assertEquals(6, result.size());
    }
}

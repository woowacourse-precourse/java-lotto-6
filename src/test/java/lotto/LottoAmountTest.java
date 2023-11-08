package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.domain.generator.LottoAmountGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoAmountTest {
    LottoAmountGenerator lottoAmountGenerator;

    @BeforeEach()
    void setUp() {
        lottoAmountGenerator = new LottoAmountGenerator();
    }

    @DisplayName("로또 구입 금액을 1000으로 나눈만큼 로또를 생성한다.")
    @ParameterizedTest()
    @CsvSource({"12000,12", "18000,18", "1000,1"})
    void createLottoAmount(int input, int output) {
        assertEquals(lottoAmountGenerator.calculateAmount(input), output);
    }
}

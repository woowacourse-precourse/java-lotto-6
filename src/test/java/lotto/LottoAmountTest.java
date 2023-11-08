package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import lotto.domain.generator.LottoAmountGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoAmountTest {
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

    @DisplayName("로또 구입 금액이 양의 정수가 아닌 경우 false를 반환한다.")
    @ParameterizedTest()
    @CsvSource({"invalid", "-12", "0"})
    void createLottoAmountNotDecimal(String input) {
        assertFalse(lottoAmountGenerator.validate(input));
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닌 경우 false를 반환한다.")
    @ParameterizedTest()
    @CsvSource({"12", "1200"})
    void createLottoAmountNotDivisible1000(String input) {
        assertFalse(lottoAmountGenerator.validate(input));
    }
}
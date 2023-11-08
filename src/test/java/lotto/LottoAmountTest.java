package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.domain.generator.LottoAmountGenerator;
import lotto.validation.Error;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoAmountTest extends NsTest {
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

    @DisplayName("로또 구입 금액이 0이상의 정수가 아닌 경우 에러메시지를 반환한다.")
    @Test
    void createLottoAmountNotDecimal() {
        assertSimpleTest(() -> {
            runException("invalid", "-12");
            assertThat(output()).contains(Error.INTEGER_ERROR.message());
        });
    }

    @DisplayName("로또 구입 금액이 0인 경우 에러메시지를 반환한다.")
    @Test
    void createLottoAmountZero() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(Error.POSITIVE_ERROR.message());
        });
    }

    @DisplayName("로또 구입 금액이 1000원 단위가 아닌 경우 에러메시지를 반환한다.")
    @Test
    void createLottoAmountNotDivisible1000() {
        assertSimpleTest(() -> {
            runException("12", "1200");
            assertThat(output()).contains(Error.DIVISIBLE_ERROR.message());
        });
    }

    protected void runMain() {
        Application.main(new String[]{});
    }
}
package lotto.validation;

import lotto.exception.CostUnitDivideException;
import lotto.exception.CostZeroException;
import lotto.exception.IncludeCharException;
import lotto.exception.InputBlankException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CostValidatorTest {


    @ParameterizedTest
    @DisplayName("로또 구매 금액 정상입력 테스트")
    @CsvSource({"'1000'", "'2000'", "'3000'"})
    void validateParsedCostTest(String readLine) {
        Assertions.assertThatCode(() -> CostValidator.validateCostReadLine(readLine))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 빈칸이 입력되었을 때")
    @CsvSource({"''", "' '", "'     '"})
    void checkBlankTest(String readLine) {
        Assertions.assertThatThrownBy(() -> CostValidator.validateCostReadLine(readLine))
                .isInstanceOf(InputBlankException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 숫자입력에 대해 문자를 포함하고있을 때")
    @CsvSource({"'-1'", "'가나다'", "'/'"})
    void checkDigitTest(String readLine) {
        Assertions.assertThatThrownBy(() -> CostValidator.validateCostReadLine(readLine))
                .isInstanceOf(IncludeCharException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 1000원 단위 금액이 아닐때")
    @CsvSource({"1001", "10100", "1111"})
    void costUnitDivideTest(int cost) {
        Assertions.assertThatThrownBy(() -> CostValidator.validateParsedCost(cost))
                .isInstanceOf(CostUnitDivideException.class);
    }

    @ParameterizedTest
    @DisplayName("[ERROR] 0일때")
    @CsvSource({"0"})
    void costZeroTest(int cost) {
        Assertions.assertThatThrownBy(() -> CostValidator.validateParsedCost(cost))
                .isInstanceOf(CostZeroException.class);
    }


}

package lotto.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.model.LottoMachine;
import lotto.model.LottoStatistics;
import lotto.model.Purchase;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(new LottoMachine(), new LottoStatistics(), new Purchase());
    }

    @DisplayName("null 입력시 예외 발생")
    @Test
    void testExceptionThrownForNullInput() {
        String nullInput = "";

        assertThatThrownBy(() -> lottoController.validateNumber(nullInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("공백 입력시 예외 발생")
    @Test
    void testExceptionThrownForWhitespaceInput() {
        String whiteSpaceInput = "1 2 3 4 5";

        assertThatThrownBy(() -> lottoController.validateNumber(whiteSpaceInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 아닌 값 입력시 예외 발생")
    @Test
    void testExceptionThrownForNotNumericInput() {
        String notNumericInput = "56000k";

        assertThatThrownBy(() -> lottoController.validateNumber(notNumericInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 ,를 제외한 다른 숫자가 없을 시 예외 발생")
    @Test
    void testExceptionThrownForOnlyCommaInput() {
        String onlyCommaInput = ",,,,,";

        assertThatThrownBy(() -> lottoController.validateLottoNumber(onlyCommaInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}



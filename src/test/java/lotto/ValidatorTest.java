package lotto;

import org.junit.jupiter.api.Test;
import validator.Validator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorTest {
    private final String ERROR_MESSAGE = "[ERROR] ";
    Validator validator = new Validator();
    @Test
    void 로또_구입_금액_입력_시_숫자_형태가_아닐_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkIsNumber("10000a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "숫자 형식이 아닙니다.");
    }
    @Test
    void 로또_구입_금액_입력_시_최소_금액_보다_작을_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkMinMoney(800))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "1000원 이상의 금액을 입력해 주세요.");
    }
    @Test
    void 로또_구입_금액_입력_시_최대_금액_보다_클_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkMaxMoney(101000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "100000원 이하의 금액을 입력해 주세요.");
    }
    @Test
    void 로또_구입_금액_입력_시_1000원으로_나누어_떨어지지_않을_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkDividedByThousand(8900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "1,000원의 단위로 입력해 주세요.");
    }
    @Test
    void 당첨_번호_입력_시_콤마로_시작할_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkStartOrEndWithComma(",1,2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "잘못된 입력 형식입니다.");
    }
    @Test
    void 당첨_번호_입력_시_콤마로_끝날_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkStartOrEndWithComma("1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "잘못된 입력 형식입니다.");
    }
    @Test
    void 당첨_번호_입력_시_콤마로_시작하고_끝날_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkStartOrEndWithComma(",1,2,3,4,5,6,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "잘못된 입력 형식입니다.");
    }
    @Test
    void 당첨_번호_입력_시_6개를_넘어갈_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkInputCount(List.of("1","2","3","4","5","6","7","8")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "입력 갯수가 잘못되었습니다.");
    }
    @Test
    void 당첨_번호_입력_시_6개보다_적을_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkInputCount(List.of("1","2","3")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "입력 갯수가 잘못되었습니다.");
    }

    @Test
    void 당첨_번호_입력_시_6개가_아닐_때_예외_발생() {
        assertThatThrownBy(() -> validator.checkInputCount(List.of("1","2","3","4","5","6","7","8")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE + "입력 갯수가 잘못되었습니다.");
    }

}

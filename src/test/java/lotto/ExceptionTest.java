package lotto;

import static lotto.constant.ExceptionConstant.ERROR_MESSAGE;
import static lotto.service.InputException.validBonus;
import static lotto.service.InputException.validLotto;
import static lotto.service.InputException.validMoney;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ExceptionTest {
    @ParameterizedTest
    @CsvSource({"-1000", "-1", "-12345"})
    void 금액_음수_예외_테스트(String input) {
        assertThatThrownBy(() -> validMoney(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @Test
    void 금액_0_예외_테스트() {
        assertThatThrownBy(() -> validMoney("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5'", "'1,2,3,4,5,6,7'"})
    void 로또_번호_6개_아닐때_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @Test
    void 로또_번호_입력_없을때_예외_테스트(){
        assertThatThrownBy(() -> validLotto(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'-1,2,3,4,5,6'", "'-1,-2,-3,-4,-5,-6'"})
    void 로또_번호_양수_아닐때_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'일,이,삼,사,오,육'", "'a,b,c,d,e,f'"})
    void 로또_번호_숫자_아닐때_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'1, 2, 3, 4, 5, 6'"})
    void 로또_번호_공백_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'1-2-3-4-5-6'", "'1.2.3.4.5.6'", "''"})
    void 로또_번호_구분자_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,46'", "'0,2,3,4,5,6'"})
    void 로또_번호_범위_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"'1,2,3,4,5,5'", "'1,2,3,1,2,3'"})
    void 로또_번호_중복_예외_테스트(String input){
        assertThatThrownBy(() -> validLotto(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_숫자_아닐때_예외_테스트(){
        assertThatThrownBy(() -> validBonus("십", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @Test
    void 보너스_번호_중복_예외_테스트(){
        assertThatThrownBy(() -> validBonus("6", List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"0", "100"})
    void 보너스_번호_범위_예외_테스트(String input){
        assertThatThrownBy(() -> validBonus(input, List.of(1,2,3,4,5,6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE.getMessage());
    }
}

package lotto.utils.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserValidatorTest {
    @Test
    @DisplayName("번호가 입력되지 않은 경우")
    void 번호가_입력되지_않은_경우() throws Exception {
        //given
        String case1 = "1,2,3,4,5,";
        String case2 = "1,2,3,4,5, ";
        //when and then
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("콤마가 중복입력된 경우")
    void 콤마가_중복입력된_경우() throws Exception {
        //given
        String case1 ="1,,2,3,4,5,6";
        String case2 ="1,2,3,4,5,,6";
        //when and then
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("콤마가 시작과 끝에 더 있는 경우")
    void 콤마가_시작과_끝에_더_있는_경우() throws Exception {
        //given
        String case1 =",1,2,3,4,5,6";
        String case2 ="1,2,3,4,5,6,";
        //when then
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
                ParserValidator.commaValid(case2))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
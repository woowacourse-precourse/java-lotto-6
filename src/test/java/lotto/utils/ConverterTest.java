package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ConverterTest {
    
    @Nested
    @DisplayName("[Converter] 기능 테스트")
    class ConverterUnitTest {
        
        @DisplayName("문자열로 된 숫자를 int 형으로 정상적으로 변환한다")
        @ParameterizedTest
        @CsvSource({"1, 1", "2, 2", "1000, 1000", "8000, 8000"})
        void parse_문자열로_된_숫자를_int_형으로_정상적으로_변환한다(String input, int target) {
            assertThat(Converter.convertToInt(input))
                    .isEqualTo(target);
        }
        
        @DisplayName("리스트를 구분자 단위로 split하여 반환한다")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,6", "12,34", "1"})
        void split_리스트를_구분자_단위로_split하여_반환한다(String input) {
            assertThatNoException().isThrownBy(
                    () -> Converter.splitBySeparator(input));
        }
    }
    
    @Nested
    @DisplayName("[Converter] 예외 테스트")
    class ConverterExceptionTest {
        
        @DisplayName("비어 있는 값이나 공백이 입력으로 들어오면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "\n", "\t"})
        void exception_비어_있는_값이나_공백이_입력으로_들어오면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.convertToInt(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
        
        @DisplayName("숫자가 아닌 값이 입력으로 들어오면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"a", "!", "가나다", "1가", "abc1"})
        void exception_숫자가_아닌_값이_입력으로_들어오면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.convertToInt(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
        
        @DisplayName("숫자 사이에 공백이 포함되어 있으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"1  ", "1 2", "   1", "1\n", "1\t2"})
        void exception_숫자_사이에_공백이_포함되어_있으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.convertToInt(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
        
        @DisplayName("리스트에 비어 있는 값이나 공백이 있으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"", " ", "\n", "\t", "1,,3", "1, ,3", "1,\n,3", "1,\t,3"})
        void exception_리스트에_비어_있는_값이나_공백이_있으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.splitBySeparator(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
    
        @DisplayName("리스트 앞뒤로 값이 없으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {",2,3,4", "1,2,3,"})
        void exception_리스트_앞뒤로_값이_없으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.splitBySeparator(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
    
        @DisplayName("리스트에 숫자가 아닌 값이 있으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,a,4", "1,2,3,가,나,다", "!,@,1,2,3"})
        void exception_리스트에_숫자가_아닌_값이_있으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.splitBySeparator(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
        
        @DisplayName("리스트에서 숫자 사이에 공백이 있으면 예외가 발생한다")
        @ParameterizedTest
        @ValueSource(strings = {"1, 2, 3, 4", "1 1,2 2,3 3"})
        void exception_리스트에서_숫자_사이에_공백이_있으면_예외가_발생한다(String input) {
            assertThatThrownBy(() -> Converter.splitBySeparator(input))
                    .isInstanceOf(LottoGameException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }
}
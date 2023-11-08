package lotto.model.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.model.converter.ListConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ListConverterTest {
    ListConverter listConverter;

    @BeforeEach
    void beforeEach() {
        listConverter = new ListConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,.,3,4,5,6,"})
    @DisplayName("입력값이 ,로 구분된다.")
    void divideByDelimiter(String lottoNumbers) {
        // given
        List<String> convertResult = Arrays.asList("", "1", "2", ".", "3", "4", "5", "6", "");

        // when & then
        assertThat(listConverter.toType(lottoNumbers)).isEqualTo(convertResult);
    }
}
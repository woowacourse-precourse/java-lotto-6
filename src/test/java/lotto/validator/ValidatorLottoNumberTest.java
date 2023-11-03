package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;


class ValidatorLottoNumberTest {
    final int START_LOTTO_NUMBER = 1;
    final int END_LOTTO_NUMBER = 45;
    final int OUT_OF_RANGE_LOTTO_NUMBER = 46;
    final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 로또_번호는_1부터_45이내에_생성되어야_함_성공(){
        //when & then
        assertDoesNotThrow(() -> IntStream.range(START_LOTTO_NUMBER, END_LOTTO_NUMBER + 1)
                .forEach(ValidatorLottoNumber::validate));
    }
    
    @Test
    void 로또_번호_범위_밖에서_생성될_경우_오류(){
        assertThatThrownBy(() -> ValidatorLottoNumber.validate(OUT_OF_RANGE_LOTTO_NUMBER))
                .hasMessageContaining(ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
    
}

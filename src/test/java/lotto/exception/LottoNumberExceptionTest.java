package lotto.exception;


import lotto.domain.LottoNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberExceptionTest {



    @DisplayName("들어온 숫자가 규정된 숫자 범위 바깥에 있는 경우 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46, 47})
    void LottoNumberRangeTest(int number) {

        Assertions.assertThatThrownBy(() -> LottoNumber.valueOf(number))
                  .isInstanceOf(IllegalArgumentException.class);

    }




}
